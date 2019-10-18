package com.android.vlad.jsonplacerholderdemo.di

import android.app.Application
import com.android.vlad.jsonplacerholderdemo.api.WebService
import com.android.vlad.jsonplacerholderdemo.data.AppDatabase
import com.android.vlad.jsonplacerholderdemo.posts.data.RemotePostDataSource
import com.android.vlad.jsonplacerholderdemo.users.data.RemoteUserDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideUserService(
        @JsonPlacerAPI okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okhttpClient, converterFactory, WebService::class.java)

    @Singleton
    @Provides
    fun provideUserRemoteDataSource(webService: WebService) = RemoteUserDataSource(webService)

    @Singleton
    @Provides
    fun providePostDataSource(webService: WebService) = RemotePostDataSource(webService)


    @JsonPlacerAPI
    @Provides
    fun providePrivateOkHttpClient(
        upstreamClient: OkHttpClient
    ): OkHttpClient {
        return upstreamClient.newBuilder()
            .build()
    }

    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDatabase.getInstance(app)


    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase) = db.userDao()

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase) = db.postDao()


    @CoroutineScopeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(WebService.ENDPOINT)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory, clazz: Class<T>
    ): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }
}

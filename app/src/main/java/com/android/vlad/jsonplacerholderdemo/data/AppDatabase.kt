package com.android.vlad.jsonplacerholderdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.vlad.jsonplacerholderdemo.comments.data.CommentDao
import com.android.vlad.jsonplacerholderdemo.model.Comment
import com.android.vlad.jsonplacerholderdemo.model.Post
import com.android.vlad.jsonplacerholderdemo.model.User
import com.android.vlad.jsonplacerholderdemo.posts.data.PostDao
import com.android.vlad.jsonplacerholderdemo.users.data.UserDao

/**
 * The Room database for this app
 */
@Database(
    entities = [User::class, Post::class, Comment::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun postDao(): PostDao

    abstract fun commentDao(): CommentDao


    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "jsonplacer-db")
                .build()
        }
    }
}

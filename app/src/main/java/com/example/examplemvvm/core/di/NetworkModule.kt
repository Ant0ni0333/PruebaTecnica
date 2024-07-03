package com.example.examplemvvm.core.di


import com.example.examplemvvm.network.ProductsApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //Provide Retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Creamos el Provider para crear el singleton de Retrofit
    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): ProductsApiClient{
        return retrofit.create(ProductsApiClient::class.java)
    }
}
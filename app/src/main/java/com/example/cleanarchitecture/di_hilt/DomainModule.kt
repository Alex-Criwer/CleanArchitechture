//package com.example.cleanarchitecture.di_hilt
//
//import com.example.cleanarchitecture.domain.repository.UserRepository
//import com.example.cleanarchitecture.domain.usecases.GetUserNameUseCase
//import com.example.cleanarchitecture.domain.usecases.SaveUserNameUseCase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ViewModelComponent
//
//@Module
////@InstallIn(ViewModelComponent::class)
//class DomainModule {
//    @Provides
//    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase {
//        return GetUserNameUseCase(userRepository = userRepository)
//    }
//
//    @Provides
//    fun provideSaveUserNameUseCase(userRepository: UserRepository): SaveUserNameUseCase {
//        return SaveUserNameUseCase(userRepository = userRepository)
//    }
//}
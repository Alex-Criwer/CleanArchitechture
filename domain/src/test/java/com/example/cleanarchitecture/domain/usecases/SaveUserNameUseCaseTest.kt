package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.never
import org.mockito.kotlin.times

class SaveUserNameUseCaseTest {
    val userRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(userRepository)
    }

    @Test
    fun noSaveDataIfAlreadyExists() {
        val testUserData = GetUserNameParam(userName = "test user name", userSurname = "test user surname")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserData)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val testParams = SaveUserNameParam(userName = "test user name")
        val actual = useCase.execute(testParams)

        Assertions.assertEquals(true, actual)
        Mockito.verify(userRepository, never()).saveName(param = any())
    }

    @Test
    fun returnTrueIfNoName() {
        val testUserData = GetUserNameParam(userName = "test user name", userSurname = "test user surname")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserData)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val expected = true
        val testParams = SaveUserNameParam(userName = "new user name")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)

        Mockito.verify(userRepository, times(1)).saveName(param = testParams)
    }

    @Test
    fun returnFalseIfNoName() {
        val testUserData = GetUserNameParam(userName = "test user name", userSurname = "test user surname")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserData)

        val useCase = SaveUserNameUseCase(userRepository = userRepository)

        val expected = false
        val testParams = SaveUserNameParam(userName = "new user name")
        Mockito.`when`(userRepository.saveName(testParams)).thenReturn(expected)

        val actual = useCase.execute(testParams)

        Assertions.assertEquals(expected, actual)

        Mockito.verify(userRepository, times(1)).saveName(param = testParams)
    }
}
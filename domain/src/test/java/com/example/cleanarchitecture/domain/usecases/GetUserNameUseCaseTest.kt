package com.example.cleanarchitecture.domain.usecases

import com.example.cleanarchitecture.domain.models.GetUserNameParam
import com.example.cleanarchitecture.domain.models.SaveUserNameParam
import com.example.cleanarchitecture.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import kotlin.math.exp

//class TestRepository: UserRepository {
//    override fun saveName(param: SaveUserNameParam): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun getName(): GetUserNameParam {
//        return GetUserNameParam(userName = "test user name", userSurname = "test user surname")
//    }
//
//}

class GetUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

    @Test
    fun shouldReturnRepositoryData() {
        val testUserData = GetUserNameParam(userName = "test user name", userSurname = "test user surname")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserData)
        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val result = useCase.execute()
        val expected = GetUserNameParam(userName = "test user name", userSurname = "test user surname")
        Assertions.assertEquals(expected, result)
    }
}
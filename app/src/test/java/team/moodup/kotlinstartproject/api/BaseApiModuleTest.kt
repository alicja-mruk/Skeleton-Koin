package team.moodup.kotlinstartproject.api

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.koin.test.KoinTest
import team.moodup.kotlinstartproject.util.ext.getMockResponse
import team.moodup.kotlinstartproject.util.testApiModules
import team.moodup.kotlinstartproject.util.testRxModule
import java.net.HttpURLConnection

class BaseApiModuleTest : KoinTest {

    val apiCLient by inject<ApiClientInterface>()
    val mockServer by inject<MockWebServer>()

    @Before
    fun before() {
        StandAloneContext.startKoin(listOf(testRxModule) + testApiModules)
    }

    @After
    fun after() {
        StandAloneContext.stopKoin()
    }

    @Test
    internal fun getUserTest() {
        mockServer.enqueue(MockResponse().getMockResponse(HttpURLConnection.HTTP_OK,"{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"delectus aut autem\",\n" +
                "  \"completed\": false\n" +
                "}"))

        val request = apiCLient
            .getUser(1)
            .test()

        request.assertSubscribed()
            .assertValueCount(1)
            .assertComplete()

    }
}
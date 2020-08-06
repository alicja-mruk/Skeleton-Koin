package team.moodup.kotlinstartproject.util.ext

import okhttp3.mockwebserver.MockResponse

fun MockResponse.getMockResponse(statusCode: Int, body: String): MockResponse {
    addHeader("Content-Type", "application/json; charset=utf-8")
    setBody(body)
    setResponseCode(statusCode)
    return this
}
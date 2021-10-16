#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++\n implementing the simple NDK is successful";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_webService_ApiClient_getUrl(
        JNIEnv* env,
        jobject /* this */) {
    std::string mUrl = "https://androidsupport.ir/pack/aparat/";
    return env->NewStringUTF(mUrl.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_utils_RetrofitStrings_getNewVideosUrl(
        JNIEnv* env,
        jobject /* this */
        ){

    std::string mUrl = "getNewVideos.php";
    return env->NewStringUTF(mUrl.c_str());

}








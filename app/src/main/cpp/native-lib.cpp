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
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle1(
        JNIEnv* env,
        jobject /* this */
        ){

    std::string mUrl = "Technology";
    return env->NewStringUTF(mUrl.c_str());

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle2(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Education";
    return env->NewStringUTF(mUrl.c_str());

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle3(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "entertainment";
    return env->NewStringUTF(mUrl.c_str());

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle4(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Fun";
    return env->NewStringUTF(mUrl.c_str());

}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle5(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Sports";
    return env->NewStringUTF(mUrl.c_str());

}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle6(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Animation";
    return env->NewStringUTF(mUrl.c_str());

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle7(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Music";
    return env->NewStringUTF(mUrl.c_str());

}
extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_CategoryVideosFragment_getCategoryTitle8(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Travel & Events";
    return env->NewStringUTF(mUrl.c_str());

}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_adapter_VideosAdapter_videoKeyForBundle(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "video";
    return env->NewStringUTF(mUrl.c_str());

}

extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_view_fragments_PlayerFragment_videoKeyForBundle(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "video";
    return env->NewStringUTF(mUrl.c_str());

}


extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_utils_AppConfig_getKeyAlias(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "Shahan960103";
    return env->NewStringUTF(mUrl.c_str());

}


extern "C" JNIEXPORT jstring JNICALL
Java_com_tispunshahryar960103_aparatmovies_utils_AppConfig_getSharedFileName(
        JNIEnv* env,
        jobject /* this */
){

    std::string mUrl = "secured_shared";
    return env->NewStringUTF(mUrl.c_str());

}








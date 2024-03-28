#include <jni.h>

#ifndef _Included_tech_noetzold_JDB_without_JNI_InMemoryNoSqlDb
#define _Included_tech_noetzold_JDB_without_JNI_InMemoryNoSqlDb
#ifdef __cplusplus
extern "C" {
#endif

JNIEXPORT void JNICALL Java_tech_noetzold_JDB_1without_1JNI_InMemoryNoSqlDb_create
  (JNIEnv *, jobject, jstring, jstring);

JNIEXPORT jstring JNICALL Java_tech_noetzold_JDB_1without_1JNI_InMemoryNoSqlDb_read
  (JNIEnv *, jobject, jstring);

JNIEXPORT void JNICALL Java_tech_noetzold_JDB_1without_1JNI_InMemoryNoSqlDb_update
  (JNIEnv *, jobject, jstring, jstring);

JNIEXPORT void JNICALL Java_tech_noetzold_JDB_1without_1JNI_InMemoryNoSqlDb_delete
  (JNIEnv *, jobject, jstring);

#ifdef __cplusplus
}
#endif
#endif

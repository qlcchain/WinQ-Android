/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_stratagile_qlink_qlinkcom */

#ifndef _Included_com_stratagile_qlink_qlinkcom
#define _Included_com_stratagile_qlink_qlinkcom
#ifdef __cplusplus
extern "C" {
#endif
#undef com_stratagile_qlink_qlinkcom_MIN_PRIORITY
#define com_stratagile_qlink_qlinkcom_MIN_PRIORITY 1L
#undef com_stratagile_qlink_qlinkcom_NORM_PRIORITY
#define com_stratagile_qlink_qlinkcom_NORM_PRIORITY 5L
#undef com_stratagile_qlink_qlinkcom_MAX_PRIORITY
#define com_stratagile_qlink_qlinkcom_MAX_PRIORITY 10L
/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    CreatedP2PNetwork
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_CreatedP2PNetwork
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetP2PConnectionStatus
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetP2PConnectionStatus
  (JNIEnv *, jobject);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    EndP2PConnection
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_EndP2PConnection
  (JNIEnv *, jobject);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    ReturnOwnP2PId
 * Signature: ([B)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_ReturnOwnP2PId
  (JNIEnv *, jobject, jbyteArray);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    AddFriend
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_AddFriend
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetNumOfFriends
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetNumOfFriends
  (JNIEnv *, jobject);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetFriendP2PPublicKey
 * Signature: (I[B)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetFriendP2PPublicKey
  (JNIEnv *, jobject, jint, jbyteArray);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetFriendNumInFriendlist
 * Signature: (Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetFriendNumInFriendlist
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetFriendConnectionStatus
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetFriendConnectionStatus
  (JNIEnv *, jobject, jint);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    SaveWifiPassword
 * Signature: (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_SaveWifiPassword
  (JNIEnv *, jobject, jstring, jstring, jstring);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    SendWifiPasswordRequest
 * Signature: (ILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_SendWifiPasswordRequest
  (JNIEnv *, jobject, jint, jstring, jstring);

/*
 * Class:     com_stratagile_qlink_qlinkcom
 * Method:    GetWifiPassword
 * Signature: (ILjava/lang/String;Ljava/lang/String;[B)I
 */
JNIEXPORT jint JNICALL Java_com_stratagile_qlink_qlinkcom_GetWifiPassword
  (JNIEnv *, jobject, jint, jstring, jstring, jbyteArray);

#ifdef __cplusplus
}
#endif
#endif
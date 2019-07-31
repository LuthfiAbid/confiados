package com.abid.confiados;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0016J\b\u00106\u001a\u000207H\u0002J\"\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\u0012\u0010=\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J.\u0010@\u001a\u0002072\u0006\u0010A\u001a\u0002042\u0006\u0010B\u001a\u0002042\u0006\u0010C\u001a\u0002042\u0006\u0010D\u001a\u0002042\u0006\u0010E\u001a\u000204R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020(X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u0006F"}, d2 = {"Lcom/abid/confiados/RegisterActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "PERMISSION_RC", "", "getPERMISSION_RC", "()I", "REQUEST_CODE_IMAGE", "getREQUEST_CODE_IMAGE", "dbRef", "Lcom/google/firebase/database/DatabaseReference;", "getDbRef", "()Lcom/google/firebase/database/DatabaseReference;", "setDbRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "fAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "filePathImage", "Landroid/net/Uri;", "getFilePathImage", "()Landroid/net/Uri;", "setFilePathImage", "(Landroid/net/Uri;)V", "firebaseStorage", "Lcom/google/firebase/storage/FirebaseStorage;", "getFirebaseStorage", "()Lcom/google/firebase/storage/FirebaseStorage;", "setFirebaseStorage", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "helperPref", "Lcom/abid/confiados/Preferences;", "getHelperPref", "()Lcom/abid/confiados/Preferences;", "setHelperPref", "(Lcom/abid/confiados/Preferences;)V", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "getStorageReference", "()Lcom/google/firebase/storage/StorageReference;", "setStorageReference", "(Lcom/google/firebase/storage/StorageReference;)V", "value", "", "getValue", "()D", "setValue", "(D)V", "GetFileExtension", "", "uri", "imageChooser", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "simpanToFirebase", "name", "email", "password", "spinner", "phone", "app_debug"})
public final class RegisterActivity extends android.support.v7.app.AppCompatActivity {
    private double value;
    private final int REQUEST_CODE_IMAGE = 10002;
    private final int PERMISSION_RC = 10003;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth fAuth;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference dbRef;
    @org.jetbrains.annotations.NotNull()
    public com.abid.confiados.Preferences helperPref;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.StorageReference storageReference;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.FirebaseStorage firebaseStorage;
    @org.jetbrains.annotations.NotNull()
    public android.net.Uri filePathImage;
    private java.util.HashMap _$_findViewCache;
    
    public final double getValue() {
        return 0.0;
    }
    
    public final void setValue(double p0) {
    }
    
    public final int getREQUEST_CODE_IMAGE() {
        return 0;
    }
    
    public final int getPERMISSION_RC() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFAuth() {
        return null;
    }
    
    public final void setFAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getDbRef() {
        return null;
    }
    
    public final void setDbRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.abid.confiados.Preferences getHelperPref() {
        return null;
    }
    
    public final void setHelperPref(@org.jetbrains.annotations.NotNull()
    com.abid.confiados.Preferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getStorageReference() {
        return null;
    }
    
    public final void setStorageReference(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.StorageReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.FirebaseStorage getFirebaseStorage() {
        return null;
    }
    
    public final void setFirebaseStorage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.net.Uri getFilePathImage() {
        return null;
    }
    
    public final void setFilePathImage(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void imageChooser() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void simpanToFirebase(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String spinner, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String GetFileExtension(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    public RegisterActivity() {
        super();
    }
}
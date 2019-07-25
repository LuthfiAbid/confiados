package com.abid.confiados;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J.\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006 "}, d2 = {"Lcom/abid/confiados/RegisterActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "dbRef", "Lcom/google/firebase/database/DatabaseReference;", "getDbRef", "()Lcom/google/firebase/database/DatabaseReference;", "setDbRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "fAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "helperPref", "Lcom/abid/confiados/Preferences;", "getHelperPref", "()Lcom/abid/confiados/Preferences;", "setHelperPref", "(Lcom/abid/confiados/Preferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "simpanToFirebase", "name", "", "email", "password", "spinner", "phone", "app_debug"})
public final class RegisterActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth fAuth;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference dbRef;
    @org.jetbrains.annotations.NotNull()
    public com.abid.confiados.Preferences helperPref;
    private java.util.HashMap _$_findViewCache;
    
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
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void simpanToFirebase(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    java.lang.String spinner, @org.jetbrains.annotations.NotNull()
    java.lang.String phone) {
    }
    
    public RegisterActivity() {
        super();
    }
}
package com.abid.confiados;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020 2\u0006\u0010\'\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020 2\u0006\u0010\'\u001a\u00020\u001aJ\u000e\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\u001aR\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\b\u00a8\u0006+"}, d2 = {"Lcom/abid/confiados/Preferences;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COUNTER_ID", "", "getCOUNTER_ID", "()Ljava/lang/String;", "USER_ID", "getUSER_ID", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "sharedSet", "Landroid/content/SharedPreferences;", "getSharedSet", "()Landroid/content/SharedPreferences;", "setSharedSet", "(Landroid/content/SharedPreferences;)V", "statusLogin", "getStatusLogin", "statusUserSlur", "getStatusUserSlur", "cekStatus", "", "()Ljava/lang/Boolean;", "getCounterId", "", "getUID", "saveCounterId", "", "counter", "saveUID", "uid", "setEmail", "email", "setStatus", "status", "setStatusInput", "setStatusUser", "statusUser", "app_debug"})
public final class Preferences {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String USER_ID = "uidx";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String COUNTER_ID = "counter";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusLogin = "STATUS";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statusUserSlur = "STATUS_USER";
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private android.content.SharedPreferences sharedSet;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUSER_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCOUNTER_ID() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusLogin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatusUserSlur() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getSharedSet() {
        return null;
    }
    
    public final void setSharedSet(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    public final void saveUID(@org.jetbrains.annotations.NotNull()
    java.lang.String uid) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUID() {
        return null;
    }
    
    public final void setStatusUser(boolean statusUser) {
    }
    
    public final void saveCounterId(int counter) {
    }
    
    public final int getCounterId() {
        return 0;
    }
    
    public final void setEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
    }
    
    public final void setStatusInput(boolean status) {
    }
    
    public final void setStatus(boolean status) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean cekStatus() {
        return null;
    }
    
    public Preferences(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super();
    }
}
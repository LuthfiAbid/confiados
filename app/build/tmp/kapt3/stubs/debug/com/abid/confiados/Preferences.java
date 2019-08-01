package com.abid.confiados;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0002\u0010\u001dJ\r\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0002\u0010\u001dJ\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u0004\u0018\u00010\u0006J\b\u0010\"\u001a\u0004\u0018\u00010\u0006J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020 J\u000e\u0010&\u001a\u00020$2\u0006\u0010\'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020\u001cJ\u000e\u00100\u001a\u00020$2\u0006\u0010-\u001a\u00020\u001cJ\u000e\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\b\u00a8\u00063"}, d2 = {"Lcom/abid/confiados/Preferences;", "", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "COUNTER_ID", "", "getCOUNTER_ID", "()Ljava/lang/String;", "USER_ID", "getUSER_ID", "dest", "getDest", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "sharedSet", "Landroid/content/SharedPreferences;", "getSharedSet", "()Landroid/content/SharedPreferences;", "setSharedSet", "(Landroid/content/SharedPreferences;)V", "statusLogin", "getStatusLogin", "statusUserSlur", "getStatusUserSlur", "cekStatus", "", "()Ljava/lang/Boolean;", "cekStatusGoogle", "getCounterId", "", "getNama", "getUID", "saveCounterId", "", "counter", "saveUID", "uid", "setEmail", "email", "setNama", "nama", "setStatus", "status", "setStatusGoogle", "statusGoogle", "setStatusInput", "setStatusUser", "statusUser", "app_debug"})
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
    private final java.lang.String dest = "DESTINATION";
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
    public final java.lang.String getDest() {
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
    
    public final void setNama(@org.jetbrains.annotations.NotNull()
    java.lang.String nama) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNama() {
        return null;
    }
    
    public final void setStatusGoogle(boolean statusGoogle) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean cekStatusGoogle() {
        return null;
    }
    
    public Preferences(@org.jetbrains.annotations.NotNull()
    android.content.Context ctx) {
        super();
    }
}
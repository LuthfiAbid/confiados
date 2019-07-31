package com.abid.confiados.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\u0018\u0000 `2\u00020\u0001:\u0001`B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u0004\u0018\u00010\u000e2\u0006\u0010D\u001a\u00020&J \u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e2\u0006\u0010I\u001a\u00020\u000eH\u0002J\b\u0010J\u001a\u00020FH\u0002J\"\u0010K\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00042\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J&\u0010P\u001a\u0004\u0018\u00010Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J-\u0010X\u001a\u00020F2\u0006\u0010L\u001a\u00020\u00042\u000e\u0010Y\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0Z2\u0006\u0010[\u001a\u00020\\H\u0016\u00a2\u0006\u0002\u0010]J\u001a\u0010^\u001a\u00020F2\u0006\u0010_\u001a\u00020Q2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006a"}, d2 = {"Lcom/abid/confiados/fragment/UploadFragment;", "Landroid/support/v4/app/Fragment;", "()V", "PERMISSION_RC", "", "getPERMISSION_RC", "()I", "REQUEST_CODE_IMAGE", "getREQUEST_CODE_IMAGE", "counter", "getCounter", "setCounter", "(I)V", "dataxxx", "", "getDataxxx", "()Ljava/lang/String;", "setDataxxx", "(Ljava/lang/String;)V", "dbRef", "Lcom/google/firebase/database/DatabaseReference;", "getDbRef", "()Lcom/google/firebase/database/DatabaseReference;", "setDbRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "destinationModel", "Lcom/abid/confiados/model/DestinationModel;", "getDestinationModel", "()Lcom/abid/confiados/model/DestinationModel;", "setDestinationModel", "(Lcom/abid/confiados/model/DestinationModel;)V", "fAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "getFAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setFAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "filePathImage", "Landroid/net/Uri;", "getFilePathImage", "()Landroid/net/Uri;", "setFilePathImage", "(Landroid/net/Uri;)V", "firebaseStorage", "Lcom/google/firebase/storage/FirebaseStorage;", "getFirebaseStorage", "()Lcom/google/firebase/storage/FirebaseStorage;", "setFirebaseStorage", "(Lcom/google/firebase/storage/FirebaseStorage;)V", "pref", "Lcom/abid/confiados/Preferences;", "getPref", "()Lcom/abid/confiados/Preferences;", "setPref", "(Lcom/abid/confiados/Preferences;)V", "storageReference", "Lcom/google/firebase/storage/StorageReference;", "getStorageReference", "()Lcom/google/firebase/storage/StorageReference;", "setStorageReference", "(Lcom/google/firebase/storage/StorageReference;)V", "value", "", "getValue", "()D", "setValue", "(D)V", "GetFileExtension", "uri", "addToFirebase", "", "destination", "startDate", "endDate", "imageChooser", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "Companion", "app_debug"})
public final class UploadFragment extends android.support.v4.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public com.abid.confiados.Preferences pref;
    private double value;
    private final int REQUEST_CODE_IMAGE = 10002;
    private final int PERMISSION_RC = 10003;
    @org.jetbrains.annotations.NotNull()
    public android.net.Uri filePathImage;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference dbRef;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.FirebaseStorage firebaseStorage;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.storage.StorageReference storageReference;
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.auth.FirebaseAuth fAuth;
    @org.jetbrains.annotations.NotNull()
    public com.abid.confiados.model.DestinationModel destinationModel;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String dataxxx;
    private int counter;
    public static final com.abid.confiados.fragment.UploadFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.abid.confiados.Preferences getPref() {
        return null;
    }
    
    public final void setPref(@org.jetbrains.annotations.NotNull()
    com.abid.confiados.Preferences p0) {
    }
    
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
    public final android.net.Uri getFilePathImage() {
        return null;
    }
    
    public final void setFilePathImage(@org.jetbrains.annotations.NotNull()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getDbRef() {
        return null;
    }
    
    public final void setDbRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.FirebaseStorage getFirebaseStorage() {
        return null;
    }
    
    public final void setFirebaseStorage(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.storage.StorageReference getStorageReference() {
        return null;
    }
    
    public final void setStorageReference(@org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.StorageReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getFAuth() {
        return null;
    }
    
    public final void setFAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.abid.confiados.model.DestinationModel getDestinationModel() {
        return null;
    }
    
    public final void setDestinationModel(@org.jetbrains.annotations.NotNull()
    com.abid.confiados.model.DestinationModel p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDataxxx() {
        return null;
    }
    
    public final void setDataxxx(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void imageChooser() {
    }
    
    private final void addToFirebase(java.lang.String destination, java.lang.String startDate, java.lang.String endDate) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String GetFileExtension(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
        return null;
    }
    
    public UploadFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/abid/confiados/fragment/UploadFragment$Companion;", "", "()V", "newInstance", "Lcom/abid/confiados/fragment/UploadFragment;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.abid.confiados.fragment.UploadFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}
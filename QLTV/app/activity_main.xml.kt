<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
android:padding="16dp"
tools:context=".MainActivity">

<TextView
android:text="Hệ thống Quản lý Thư viện"
android:textSize="22sp"
android:textStyle="bold"
android:gravity="center"
android:layout_width="match_parent"
android:layout_height="wrap_content" />

<LinearLayout
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:orientation="horizontal"
android:layout_marginTop="16dp">

<EditText
android:id="@+id/editStudent"
android:layout_width="0dp"
android:layout_height="wrap_content"
android:layout_weight="1"
android:hint="Sinh viên" />

<Button
android:id="@+id/btnChange"
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:text="Thay đổi"
android:layout_marginStart="8dp" />
</LinearLayout>

<TextView
android:id="@+id/tvListTitle"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Danh sách sách"
android:textStyle="bold"
android:layout_marginTop="16dp" />

<ListView
android:id="@+id/listBooks"
android:layout_width="match_parent"
android:layout_height="0dp"
android:layout_weight="1"
android:divider="@android:color/darker_gray"
android:dividerHeight="1dp" />

<TextView
android:id="@+id/tvEmpty"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Bạn chưa mượn quyển sách nào\nNhấn 'Thêm' để bắt đầu hành trình đọc sách!"
android:gravity="center"
android:padding="12dp"
android:visibility="gone" />

<Button
android:id="@+id/btnAdd"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Thêm"
android:layout_marginTop="8dp" />

</LinearLayout>

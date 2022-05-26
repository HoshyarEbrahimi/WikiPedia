package com.hoshyar.ebrahimi.wikipedia.data

import android.os.Parcel
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize



data class ItemPost(
	 // for explore =>
	 val imgUrl: String ,
	 val txtTitle: String ,
	 val txtSubtitle: String ,
	 val txtDetail: String ,
	 //for trend =>
	 val isTrend: Boolean ,
	 val insight: String
) : Parcelable {
	 constructor(parcel: Parcel) : this(
			parcel.readString().toString() ,
			parcel.readString().toString() ,
			parcel.readString().toString() ,
			parcel.readString().toString() ,
			parcel.readByte() != 0.toByte() ,
			parcel.readString().toString()
	 ) {
	 }
	 
	 override fun writeToParcel(parcel: Parcel , flags: Int) {
			parcel.writeString(imgUrl)
			parcel.writeString(txtTitle)
			parcel.writeString(txtSubtitle)
			parcel.writeString(txtDetail)
			parcel.writeByte(if (isTrend) 1 else 0)
			parcel.writeString(insight)
	 }
	 
	 override fun describeContents(): Int {
			return 0
	 }
	 
	 companion object CREATOR : Parcelable.Creator<ItemPost> {
			override fun createFromParcel(parcel: Parcel): ItemPost {
				 return ItemPost(parcel)
			}
			
			override fun newArray(size: Int): Array<ItemPost?> {
				 return arrayOfNulls(size)
			}
	 }
}
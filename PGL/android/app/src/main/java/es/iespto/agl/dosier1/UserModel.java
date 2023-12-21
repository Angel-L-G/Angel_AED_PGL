package es.iespto.agl.dosier1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class UserModel implements Parcelable {
    private String nombre;
    private String correo;
    private int edad;


    protected UserModel(Parcel in) {
        nombre = in.readString();
        correo = in.readString();
        edad = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(correo);
        dest.writeInt(edad);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}

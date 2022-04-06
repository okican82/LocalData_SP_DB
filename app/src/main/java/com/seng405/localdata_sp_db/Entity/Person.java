package com.seng405.localdata_sp_db.Entity;

import android.os.Parcelable;


public class Person implements Parcelable
{

    private String name;
    private String surname;
    private Integer userId;
    private String phoneNumber;
    private String company;
    private String email;

    public final static Creator<Person> CREATOR = new Creator<Person>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Person createFromParcel(android.os.Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return (new Person[size]);
        }

    }
            ;

    protected Person(android.os.Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.surname = ((String) in.readValue((String.class.getClassLoader())));
        this.userId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.phoneNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public Person() {
    }

    /**
     *
     * @param phoneNumber
     * @param surname
     * @param name
     * @param company
     * @param userId
     * @param email
     */
    public Person(String name, String surname, Integer userId, String phoneNumber, String company, String email) {
        super();
        this.name = name;
        this.surname = surname;
        this.userId = userId;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(surname);
        dest.writeValue(userId);
        dest.writeValue(phoneNumber);
        dest.writeValue(company);
        dest.writeValue(email);
    }

    public int describeContents() {
        return 0;
    }

}
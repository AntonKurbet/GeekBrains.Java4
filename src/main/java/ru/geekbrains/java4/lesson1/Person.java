package ru.geekbrains.java4.lesson1;

class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    private Person() {}

    public static class Builder {
        private Person person;

        public Builder() {
            person = new Person();
        }
        public Builder setFirstName(String firstName) {
            person.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            person.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            person.middleName = middleName;
            return this;
        }

        public Builder setCountry(String country) {
            person.country = country;
            return this;
        }

        public Builder setAddress(String address) {
            person.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            person.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            person.age = age;
            return this;
        }

        public Builder setGender(String gender) {
            person.gender = gender;
            return this;
        }

        public Person build() {
            return person;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s. %s %s %d %s %s %s",
                this.firstName,
                this.middleName,
                this.lastName,
                this.gender,
                this.age,
                this.country,
                this.address,
                this.phone);
    }
}

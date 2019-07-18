package com.table;

public class User {
        //    id INT PRIMARY KEY AUTO_INCREMENT,
//    username VARCHAR(20),
//    PASSWORD VARCHAR(30),
//    sex CHAR(2),
//    hobbys VARCHAR(200),
//    phone VARCHAR(11),
//    email VARCHAR(30),
//    address VARCHAR(100)
        private String username;
        private String password;
        private String sex;
        private String hobbys;
        private String phone;
        private String email;
        private String address;

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
        public String toString() {
            return "UserDao{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", sex='" + sex + '\'' +
                    ", hobbys='" + hobbys + '\'' +
                    ", phone=" + phone +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return this.password;
        }



    public void setPassword(String password) {
            this.password = password;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHobbys() {
            return hobbys;
        }

        public void setHobbys(String hobbys) {
            this.hobbys = hobbys;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public User() {

        }

        public User(String username, String password, String sex, String hobbys, String phone, String email, String address) {

            this.username = username;
            this.password = password;
            this.sex = sex;
            this.hobbys = hobbys;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }
    }



package com.baizhi.entity;

public class User {

        private Integer id;
        private String username;
        private String password;
        private String phone;
        private String  email;
        private String source;
        private  String ip;
        private String status;

        public User() {
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", phone='" + phone + '\'' +
                    ", email='" + email + '\'' +
                    ", source='" + source + '\'' +
                    ", ip='" + ip + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }

        public User(Integer id, String username, String password, String phone, String email, String source, String ip, String status) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.phone = phone;
            this.email = email;
            this.source = source;
            this.ip = ip;
            this.status = status;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
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

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }



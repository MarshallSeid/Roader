package com.example.marchness.androidappskeleton;
import java.util.UUID;

/**
 * Created by Marchness on 3/2/16.
 */
public class User {
        String name;
        String password;
        String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setUserPassword(String password) {
            this.password = password; //Deal with hashing passwords later on 
        }

        public String getUserId(){
            return this.id;
        }

        public User(){
            this.id = UUID.randomUUID().toString();
        }
    }
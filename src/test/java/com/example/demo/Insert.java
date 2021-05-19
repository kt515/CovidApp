//package com.example.demo;
//
//import com.example.demo.entity.User;
//import com.github.javafaker.Faker;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Random;
//
//@Component
//class Insert implements CommandLineRunner {
//
//    @Autowired
//    private UserRepository repo;
//
//    // creating 1000 users
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        Faker faker = new Faker(); // used to generate fake names address... cannot use for unique
//        User user = new User(); // new user entity
//        Random rand = new Random();
//
//        for (int i = 1; i < 1001; i++) {
//
//
//            int randrole = rand.nextInt(4); // from 0 to 3
//
//            switch (randrole) {
//                case 0:
//                    user.setRoles("ROLE_PUBLIC");
//                    break;
//                case 1:
//                    user.setRoles("ROLE_BUSINESS");
//                    break;
//                case 2:
//                    user.setRoles("ROLE_HCORG");
//                    break;
//                case 3:
//                    user.setRoles("ROLE_HCSTAFF");
//                    break;
//            }
//
//            user.setPassword("password");
//
//            int randphone1 = 9; // 1st digit 9
//            int randphone2 = rand.nextInt(10); // 0 to 9
//            int randphone3 = rand.nextInt(10); // 0 to 9
//            int randphone4 = rand.nextInt(10); // 0 to 9
//            int randphone5 = rand.nextInt(10); // 0 to 9
//            int randphone6 = rand.nextInt(10); // 0 to 9
//            int randphone7 = rand.nextInt(10); // 0 to 9
//            int randphone8 = rand.nextInt(10); // 0 to 9
//            String randphone1str = String.valueOf(randphone1); // convert to String
//            String randphone2str = String.valueOf(randphone2);
//            String randphone3str = String.valueOf(randphone3);
//            String randphone4str = String.valueOf(randphone4);
//            String randphone5str = String.valueOf(randphone5);
//            String randphone6str = String.valueOf(randphone6);
//            String randphone7str = String.valueOf(randphone7);
//            String randphone8str = String.valueOf(randphone8);
//            String randphone = randphone1str + randphone2str + randphone3str + randphone4str
//                    + randphone5str + randphone6str + randphone7str + randphone8str; // combine numbers
//            user.setContact(randphone);
//
//            String randnric1str = "S";
//            int randnric2 = rand.nextInt(10);
//            int randnric3 = rand.nextInt(10);
//            int randnric4 = rand.nextInt(10);
//            int randnric5 = rand.nextInt(10);
//            int randnric6 = rand.nextInt(10);
//            int randnric7 = rand.nextInt(10);
//            String randnric2str = String.valueOf(randnric2);
//            String randnric3str = String.valueOf(randnric3);
//            String randnric4str = String.valueOf(randnric4);
//            String randnric5str = String.valueOf(randnric5);
//            String randnric6str = String.valueOf(randnric6);
//            String randnric7str = String.valueOf(randnric7);
//            String randnric = randnric1str + randnric2str + randnric3str + randnric4str
//                    + randnric5str + randnric6str + randnric7str;
//            user.setID(randnric);
//
//            String firstName = faker.name().firstName();
//            String lastName = faker.name().lastName();
//            String address = faker.address().fullAddress();
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setAddress(address);
//            user.setPassword("password");
//
//
//            User savedUser = repo.save(user); //saved to repository
//        }
//    }
//}

package com.example.demo.repository;

import com.example.demo.entity.Public;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface PublicRepository extends JpaRepository<Public, User> {

    @Query("SELECT p FROM Public p WHERE p.publicId.public_userid.id = ?1")
    Optional<Public> findByUsername(String username);

    List<Public> findAll();

    @Modifying
    @Query("update Public u set u.publicId.public_userid = :public_userid, " +
            "u.publicId.first_name = :first_name, u.publicId.lastName = :lastName," +
            "u.publicId.dob = :dob, u.contact_no = :contact_no, " +
            "u.residential_address = :residential_address" +
            " where u.publicId.public_userid = :public_userid")
    void updatePublic(@Param("public_userid") User public_userid,
                      @Param("first_name") String first_name,
                    @Param("lastName") String lastName,
                    @Param("dob") Date dob,
                    @Param("contact_no") Integer contact_no,
                    @Param("residential_address") String residential_address);                            ;

    @Modifying
    @Query(value = "insert into Public (public_userid, first_name, last_name, dob, " +
            "contact_no,residential_address,positive_case,vaccinated) " +
            "values (:public_userid, :first_name, :lastName, :dob, " +
            ":contact_no,:residential_address,:positive_case,:vaccinated)", nativeQuery = true)
    void createPublic(@Param("public_userid") User public_userid,
                      @Param("first_name") String first_name,
                      @Param("lastName") String lastName,
                      @Param("dob") Date dob,
                      @Param("contact_no") Integer contact_no,
                      @Param("residential_address") String residential_address,
                      @Param("positive_case") boolean positive_case,
                      @Param("vaccinated") boolean vaccinated);
}

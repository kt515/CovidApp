package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "public")
public class Public implements Serializable {

    @EmbeddedId
    private PublicId publicId;

    @Column(name = "contact_no")
    private Integer contact_no;

    @Column(name = "residential_address")
    private String residential_address;

    @Column(name = "positive_case")
    private boolean positive_case;

    @Column(name = "vaccinated")
    private boolean vaccinated;

    @ManyToMany(mappedBy = "public_record")
    private List<Record> public_record;

    @ManyToMany(mappedBy = "public_cert")
    private List<VaccineCert> public_cert;

    public Public() {
    }

    public Public(PublicId publicId, Integer contact_no, String residential_address, boolean positive_case,
            boolean vaccinated) {
        this.publicId = publicId;
        this.contact_no = contact_no;
        this.residential_address = residential_address;
        this.positive_case = positive_case;
        this.vaccinated = vaccinated;
    }

    public PublicId getPublicId() {
        return publicId;
    }

    public void setPublicId(PublicId publicId) {
        this.publicId = publicId;
    }

    public Integer getContact_no() {
        return contact_no;
    }

    public void setContact_no(Integer contact_no) {
        this.contact_no = contact_no;
    }

    public String getResidential_address() {
        return residential_address;
    }

    public void setResidential_address(String residential_address) {
        this.residential_address = residential_address;
    }

    public boolean isPositive_case() {
        return positive_case;
    }

    public void setPositive_case(boolean positive_case) {
        this.positive_case = positive_case;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    @Override
    public String toString() {
        return "Public [contact_no=" + contact_no + ", positive_case=" + positive_case + ", publicId=" + publicId
                + ", residential_address=" + residential_address + ", vaccinated=" + vaccinated + "]";
    }

}

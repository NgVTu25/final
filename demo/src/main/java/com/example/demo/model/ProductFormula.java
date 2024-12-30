package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "product_formulas")
public class ProductFormula {

    @Id
    private String id;
    private String name;
    private String identifier;
    private List<Excipient> excipients;
    private List<FormulaVersion> formulaVersions;

    // Getters and Setters for ProductFormula
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<Excipient> getExcipients() {
        return excipients;
    }

    public void setExcipients(List<Excipient> excipients) {
        this.excipients = excipients;
    }

    public List<FormulaVersion> getFormulaVersions() {
        return formulaVersions;
    }

    public void setFormulaVersions(List<FormulaVersion> formulaVersions) {
        this.formulaVersions = formulaVersions;
    }

    public static class Excipient {
        private String name;
        private String concentration;
        private String role;

        // Getters and Setters for Excipient
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getConcentration() {
            return concentration;
        }

        public void setConcentration(String concentration) {
            this.concentration = concentration;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

    public static class FormulaVersion {
        private String createdDate;
        private String createdBy;
        private String versionNote;

        // Getters and Setters for FormulaVersion
        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public String getVersionNote() {
            return versionNote;
        }

        public void setVersionNote(String versionNote) {
            this.versionNote = versionNote;
        }
    }
}

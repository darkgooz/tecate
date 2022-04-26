package com.mir4.nftsearch;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.mir4.nftsearch");

        noClasses()
            .that()
                .resideInAnyPackage("com.mir4.nftsearch.service..")
            .or()
                .resideInAnyPackage("com.mir4.nftsearch.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..com.mir4.nftsearch.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}

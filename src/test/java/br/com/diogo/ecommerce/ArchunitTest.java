package br.com.diogo.ecommerce;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "br.com.diogo.ecommerce", importOptions = ImportOption.DoNotIncludeTests.class)
public class ArchunitTest {



    @ArchTest
    ArchRule ports_sao_interfaces = classes().that().resideInAPackage("..domain.repository").should().beInterfaces();
    ArchRule adapters_implementam_ports = classes().that().resideInAPackage("..infrastructure.repository").should().haveSimpleNameEndingWith("Adapter");

    @ArchTest
    ArchRule  camada_domain_esta_isolada = classes().that().
            resideInAPackage("..domain..").should().onlyAccessClassesThat()
            .resideInAnyPackage("..domain..","..application");

    @ArchTest
    public static final ArchRule hexagonal_arch = layeredArchitecture()
            .layer("adapter").definedBy("..infrastructure..")
            .layer("ports").definedBy("..application..")
            .layer("domain").definedBy("..domain..")
            .whereLayer("domain").mayOnlyBeAccessedByLayers("ports")
            .whereLayer("ports").mayOnlyBeAccessedByLayers("domain","ports","adapter")
            .whereLayer("adapter").mayNotBeAccessedByAnyLayer();
}

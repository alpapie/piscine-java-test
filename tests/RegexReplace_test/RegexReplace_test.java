import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.fail;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class RegexReplaceTest {

        @Test
        void removeUnits() {
                String res1 = RegexReplace.removeUnits("15323cm");
                assertThat(res1)
                                .withFailMessage("The \"15323cm\" should be replace by \"15323\", but was %s", res1)
                                .isEqualTo("15323");
                String res9 = RegexReplace.removeUnits("15323scm");
                assertThat(res9)
                                .withFailMessage("The \"15323scm\" should be replace by \"15323scm\", but was %s", res9)
                                .isEqualTo("15323scm");
                String res2 = RegexReplace.removeUnits("15323 cm");
                assertThat(res2)
                                .withFailMessage("The \"15323 cm\" should be replace by \"15323 cm\", but was %s", res2)
                                .isEqualTo("15323 cm");
                String res3 = RegexReplace.removeUnits("15323cm²");
                assertThat(res3)
                                .withFailMessage("The \"15323cm²\" should be replace by \"15323cm²\", but was %s", res3)
                                .isEqualTo("15323cm²");
                String res4 = RegexReplace.removeUnits("15323cm et demi");
                assertThat(res4)
                                .withFailMessage("The \"15323cm\" should be replace by \"15323 et demi\", but was %s",
                                                res4)
                                .isEqualTo("15323 et demi");
                String res5 = RegexReplace.removeUnits("15323€");
                assertThat(res5)
                                .withFailMessage("The \"15323€\" should be replace by \"15323\", but was %s", res5)
                                .isEqualTo("15323");
                String res6 = RegexReplace.removeUnits("15323 €");
                assertThat(res6)
                                .withFailMessage("The \"15323 €\" should be replace by \"15323 €\", but was %s", res6)
                                .isEqualTo("15323 €");
                String res7 = RegexReplace.removeUnits("15323€²");
                assertThat(res7)
                                .withFailMessage("The \"15323€²\" should be replace by \"15323€²\", but was %s", res7)
                                .isEqualTo("15323€²");
                String res8 = RegexReplace.removeUnits("15323€ et demi");
                assertThat(res8)
                                .withFailMessage(
                                                "The \"15323€ et demi\" should be replace by \"15323 et demi\", but was %s",
                                                res8)
                                .isEqualTo("15323 et demi");
                String res10 = RegexReplace.removeUnits("15323m€");
                assertThat(res10)
                                .withFailMessage("The \"15323m€\" should be replace by \"15323m€\", but was %s", res10)
                                .isEqualTo("15323m€");
        }

        @Test
        void obfuscateEmail() {
                // Basic obfuscation
                String res1 = RegexReplace.obfuscateEmail("john.doe@example.com");
                assertThat(res1)
                                .withFailMessage(
                                                "The email \"john.doe@example.com\" should be obfuscated to \"john.***@*******.com\", but was %s",
                                                res1)
                                .isEqualTo("john.***@*******.com");

                // Third level domain
                String res2 = RegexReplace.obfuscateEmail("jann@example.co.edu");
                assertThat(res2)
                                .withFailMessage(
                                                "The email \"jann@example.co.edu\" should be obfuscated to \"jan*@*******.co.***\", but was %s",
                                                res2)
                                .isEqualTo("jan*@*******.co.***");

                // Second level domain
                String res3 = RegexReplace.obfuscateEmail("jackob@example.fr");
                assertThat(res3)
                                .withFailMessage(
                                                "The email \"jackob@example.fr\" should be obfuscated to \"jac***@*******.**\", but was %s",
                                                res3)
                                .isEqualTo("jac***@*******.**");

                // Username with dot
                String res4 = RegexReplace.obfuscateEmail("jo.d@example.com");
                assertThat(res4)
                                .withFailMessage(
                                                "The email \"jo.d@example.com\" should be obfuscated to \"jo.*@*******.com\", but was %s",
                                                res4)
                                .isEqualTo("jo.*@*******.com");

                // Username with hyphen
                String res5 = RegexReplace.obfuscateEmail("jo-h@example.com");
                assertThat(res5)
                                .withFailMessage(
                                                "The email \"jo-h@example.com\" should be obfuscated to \"jo-*@*******.com\", but was %s",
                                                res5)
                                .isEqualTo("jo-*@*******.com");

                // Username with underscore
                String res6 = RegexReplace.obfuscateEmail("jo_h@example.com");
                assertThat(res6)
                                .withFailMessage(
                                                "The email \"jo_h@example.com\" should be obfuscated to \"jo_*@*******.com\", but was %s",
                                                res6)
                                .isEqualTo("jo_*@*******.com");

                // Uncommon top level domain
                String res7 = RegexReplace.obfuscateEmail("joh.d@example.io");
                assertThat(res7)
                                .withFailMessage(
                                                "The email \"joh.d@example.io\" should be obfuscated to \"joh.*@*******.**\", but was %s",
                                                res7)
                                .isEqualTo("joh.*@*******.**");

                // Common top level domain
                String res8 = RegexReplace.obfuscateEmail("joh.d@example.com");
                assertThat(res8)
                                .withFailMessage(
                                                "The email \"joh.d@example.com\" should be obfuscated to \"joh.*@*******.com\", but was %s",
                                                res8)
                                .isEqualTo("joh.*@*******.com");

                // Third level domain with common top level
                String res9 = RegexReplace.obfuscateEmail("joh.d@example.co.net");
                assertThat(res9)
                                .withFailMessage(
                                                "The email \"joh.d@example.co.net\" should be obfuscated to \"joh.*@*******.co.***\", but was %s",
                                                res9)
                                .isEqualTo("joh.*@*******.co.***");
        }
}

package org.rjae.springresearch;

import org.junit.jupiter.api.Test;

public class SpringResearchApplicationIntegrationTests {
    @Test
    void mainMustRunApplication() {
        SpringResearchApplication.main(new String[] {"--spring.main.log-startup-info=false"});
    }
}


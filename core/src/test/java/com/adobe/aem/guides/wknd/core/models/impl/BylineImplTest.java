package com.adobe.aem.guides.wknd.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AemContextExtension.class)
public class BylineImplTest {

    private final AemContext ctx = new AemContext();

    @BeforeEach
    public void setUp() throws Exception {
        //  registers the Sling Model to be tested
        ctx.addModelsForClasses(BylineImpl.class);
        // loads resource structures into the mock context
        ctx.load().json("/com/adobe/aem/guides/wknd/core/models/impl/BylineImplTest.json", "/content");
    }

    @Test
    void testGetName() {
        fail("Not yet implemented");
    }

    @Test
    void testGetOccupations() {
        fail("Not yet implemented");
    }

    @Test
    void testIsEmpty() {
        fail("Not yet implemented");
    }

}

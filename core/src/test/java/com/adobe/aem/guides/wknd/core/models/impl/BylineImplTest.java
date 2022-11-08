package com.adobe.aem.guides.wknd.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;

import com.adobe.aem.guides.wknd.core.models.Byline;
import com.adobe.cq.wcm.core.components.models.Image;
import com.google.common.collect.ImmutableList;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;


@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class BylineImplTest {

    private final AemContext ctx = new AemContext();

    @Mock
    private Image image;

    @Mock
    private ModelFactory modelFactory;

    @BeforeEach
    public void setUp() throws Exception {
        //  registers the Sling Model to be tested
        ctx.addModelsForClasses(BylineImpl.class);
        // loads resource structures into the mock context
        ctx.load().json("/com/adobe/aem/guides/wknd/core/models/impl/BylineImplTest.json", "/content");
        lenient().when(modelFactory.getModelFromWrappedRequest(eq(ctx.request()), any(Resource.class), eq(Image.class)))
                .thenReturn(image);
        ctx.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
    }

    @Test
    public void testGetName() {
        final String expected = "Jane Doe";
        ctx.currentResource("/content/byline");
        Byline byline = ctx.request().adaptTo(Byline.class);
        String actual = byline.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetOccupations() {
        List<String> expected = new ImmutableList.Builder<String>()
                .add("Blogger")
                .add("Photographer")
                .add("YouTuber")
                .build();
        ctx.currentResource("/content/byline");
        Byline byline = ctx.request().adaptTo(Byline.class);
        List<String> actual = byline.getOccupations();
        assertEquals(expected, actual);
    }

    @Test
    void testIsEmpty() {
        ctx.currentResource("/content/empty");
        Byline byline = ctx.request().adaptTo(Byline.class);
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutName() {
        ctx.currentResource("/content/without-name");
        Byline byline = ctx.request().adaptTo(Byline.class);
        assertTrue(byline.isEmpty());
    }

    @Test
    public void testIsEmpty_WithoutOccupations() {
        ctx.currentResource("/content/without-occupations");
        Byline byline = ctx.request().adaptTo(Byline.class);
        assertTrue(byline.isEmpty());
    }

}
package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

/**
 * Represents the Byline AEM Component for the WKND Site project.
 **/
public interface Byline {
    /***
     * @return a string to display as the name.
     */
    String getName();

    /***
     * Occupations are to be sorted alphabetically in a descending order.
     *
     * @return a list of occupations.
     */
    List<String> getOccupations();

    /***
     * @return a boolean if the component has enough content to display.
     *  is used to determine if the component has any content to render or if it is waiting to be configured.
     */
    boolean isEmpty();
}

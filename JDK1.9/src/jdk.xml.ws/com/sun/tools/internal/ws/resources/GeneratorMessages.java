/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.tools.internal.ws.resources;

import java.util.Locale;
import java.util.ResourceBundle;
import com.sun.istack.internal.localization.Localizable;
import com.sun.istack.internal.localization.LocalizableMessageFactory;
import com.sun.istack.internal.localization.LocalizableMessageFactory.ResourceBundleSupplier;
import com.sun.istack.internal.localization.Localizer;


/**
 * Defines string formatting method for each constant in the resource file
 *
 */
public final class GeneratorMessages {

    private final static String BUNDLE_NAME = "com.sun.tools.internal.ws.resources.generator";
    private final static LocalizableMessageFactory MESSAGE_FACTORY = new LocalizableMessageFactory(BUNDLE_NAME, new GeneratorMessages.BundleSupplier());
    private final static Localizer LOCALIZER = new Localizer();

    public static Localizable localizableGENERATOR_INDENTINGWRITER_CHARSET_CANTENCODE(Object arg0) {
        return MESSAGE_FACTORY.getMessage("generator.indentingwriter.charset.cantencode", arg0);
    }

    /**
     * WSDL has some characters which native java encoder can''t encode: "{0}"
     *
     */
    public static String GENERATOR_INDENTINGWRITER_CHARSET_CANTENCODE(Object arg0) {
        return LOCALIZER.localize(localizableGENERATOR_INDENTINGWRITER_CHARSET_CANTENCODE(arg0));
    }

    public static Localizable localizableGENERATOR_CANNOT_CREATE_DIR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("generator.cannot.create.dir", arg0);
    }

    /**
     * can''t create directory: {0}
     *
     */
    public static String GENERATOR_CANNOT_CREATE_DIR(Object arg0) {
        return LOCALIZER.localize(localizableGENERATOR_CANNOT_CREATE_DIR(arg0));
    }

    public static Localizable localizableGENERATOR_INTERNAL_ERROR_SHOULD_NOT_HAPPEN(Object arg0) {
        return MESSAGE_FACTORY.getMessage("generator.internal.error.should.not.happen", arg0);
    }

    /**
     * internal error (should not happen): {0}
     *
     */
    public static String GENERATOR_INTERNAL_ERROR_SHOULD_NOT_HAPPEN(Object arg0) {
        return LOCALIZER.localize(localizableGENERATOR_INTERNAL_ERROR_SHOULD_NOT_HAPPEN(arg0));
    }

    public static Localizable localizableGENERATOR_NESTED_GENERATOR_ERROR(Object arg0) {
        return MESSAGE_FACTORY.getMessage("generator.nestedGeneratorError", arg0);
    }

    /**
     * generator error: {0}
     *
     */
    public static String GENERATOR_NESTED_GENERATOR_ERROR(Object arg0) {
        return LOCALIZER.localize(localizableGENERATOR_NESTED_GENERATOR_ERROR(arg0));
    }

    public static Localizable localizableGENERATOR_SEI_CLASS_ALREADY_EXIST(Object arg0, Object arg1) {
        return MESSAGE_FACTORY.getMessage("generator.sei.classAlreadyExist", arg0, arg1);
    }

    /**
     * Could not generate SEI, class: {0} already exists. Rename wsdl:portType "{1}" using JAX-WS customization
     *
     */
    public static String GENERATOR_SEI_CLASS_ALREADY_EXIST(Object arg0, Object arg1) {
        return LOCALIZER.localize(localizableGENERATOR_SEI_CLASS_ALREADY_EXIST(arg0, arg1));
    }

    public static Localizable localizableGENERATOR_SERVICE_CLASS_ALREADY_EXIST(Object arg0, Object arg1) {
        return MESSAGE_FACTORY.getMessage("generator.service.classAlreadyExist", arg0, arg1);
    }

    /**
     * Could not generate Service, class: {0} already exists. Rename wsdl:Service "{1}" using JAX-WS customization
     *
     */
    public static String GENERATOR_SERVICE_CLASS_ALREADY_EXIST(Object arg0, Object arg1) {
        return LOCALIZER.localize(localizableGENERATOR_SERVICE_CLASS_ALREADY_EXIST(arg0, arg1));
    }

    private static class BundleSupplier
        implements ResourceBundleSupplier
    {


        public ResourceBundle getResourceBundle(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        }

    }

}

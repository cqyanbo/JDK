/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.bind.attachment;

import javax.activation.DataHandler;

/**
 * <p>Enables JAXB unmarshalling of a root document containing optimized binary data formats.</p>
 *
 * <p>This API enables an efficient cooperative processing of optimized
 * binary data formats between a JAXB 2.0 implementation and MIME-based package
 * processor (MTOM/XOP and WS-I AP 1.0). JAXB unmarshals the body of a package, delegating the
 * understanding of the packaging format being used to a MIME-based
 * package processor that implements this abstract class.</p>
 *
 * <p>This abstract class identifies if a package requires XOP processing, {@link #isXOPPackage()}
 * and provides retrieval of binary content stored as attachments by content-id.</p>
 *
 * <h2>Identifying the content-id, cid, to pass to {@code getAttachment*(String cid)}</h2>
 * <ul>
 * <li>
 * For XOP processing, the infoset representation of the cid is described
 * in step 2a in
 * <a href="http://www.w3.org/TR/2005/REC-xop10-20050125/#interpreting_xop_packages">Section 3.2 Interpreting XOP Packages</a>
 * </li>
 * <li>
 * For WS-I AP 1.0, the cid is identified as an element or attribute of
 * type {@code ref:swaRef} specified in
 * <a href="http://www.ws-i.org/Profiles/AttachmentsProfile-1.0-2004-08-24.html#Referencing_Attachments_from_the_SOAP_Envelope">
 * Section 4.4 Referencing Attachments from the SOAP Envelope</a>
 * </li>
 * </ul>
 *
 * @author Marc Hadley
 * @author Kohsuke Kawaguchi
 * @author Joseph Fialli
 *
 * @since 1.6, JAXB 2.0
 *
 * @see javax.xml.bind.Unmarshaller#setAttachmentUnmarshaller(AttachmentUnmarshaller)
 *
 * @see <a href="http://www.w3.org/TR/2005/REC-xop10-20050125/">XML-binary Optimized Packaging</a>
 * @see <a href="http://www.ws-i.org/Profiles/AttachmentsProfile-1.0-2004-08-24.html">WS-I Attachments Profile Version 1.0.</a>
 * @see <a href="http://www.w3.org/TR/xml-media-types/">Describing Media Content of Binary Data in XML</a>
 */
public abstract class AttachmentUnmarshaller {
   /**
    * <p>Lookup MIME content by content-id, {@code cid}, and return as a {@link DataHandler}.</p>
    *
    * <p>The returned {@code DataHandler} instance must be configured
    * to meet the following required mapping constaint.
    * <table summary="" border="2" rules="all" cellpadding="4">
    *   <thead>
    *     <tr>
    *       <th align="center" colspan="2">
    *       Required Mappings between MIME and Java Types
    *       </tr>
    *     <tr>
    *       <th>MIME Type</th>
    *       <th>Java Type</th>
    *     </tr>
    *     <tr>
    *       <th>{@code DataHandler.getContentType()}</th>
    *       <th>{@code instanceof DataHandler.getContent()}</th>
    *     </tr>
    *   </thead>
    *   <tbody>
    *     <tr>
    *       <td>image/gif</td>
    *       <td>java.awt.Image</td>
    *     </tr>
    *     <tr>
    *       <td>image/jpeg</td>
    *       <td>java.awt.Image</td>
    *     </tr>
    *     <tr>
    *       <td>text/xml  or application/xml</td>
    *       <td>javax.xml.transform.Source</td>
    *     </tr>
    *   </tbody>
    *  </table>
    * Note that it is allowable to support additional mappings.
    *
    * @param cid It is expected to be a valid lexical form of the XML Schema
    * {@code xs:anyURI} datatype. If {@link #isXOPPackage()}{@code ==true},
    * it must be a valid URI per the {@code cid:} URI scheme (see <a href="http://www.ietf.org/rfc/rfc2387.txt">RFC 2387</a>)
    *
    * @return
    *       a {@link DataHandler} that represents the MIME attachment.
    *
    * @throws IllegalArgumentException if the attachment for the given cid is not found.
    */
   public abstract DataHandler getAttachmentAsDataHandler(String cid);

    /**
     * <p>Retrieve the attachment identified by content-id, {@code cid}, as a {@code byte[]}.
     *
     * @param cid It is expected to be a valid lexical form of the XML Schema
     * {@code xs:anyURI} datatype. If {@link #isXOPPackage()}{@code ==true},
     * it must be a valid URI per the {@code cid:} URI scheme (see <a href="http://www.ietf.org/rfc/rfc2387.txt">RFC 2387</a>)
     *
     * @return byte[] representation of attachment identified by cid.
     *
    * @throws IllegalArgumentException if the attachment for the given cid is not found.
     */
    public abstract byte[] getAttachmentAsByteArray(String cid);

    /**
     * <p>Read-only property that returns true if JAXB unmarshaller needs to perform XOP processing.</p>
     *
     * <p>This method returns {@code true} when the constraints specified
     * in  <a href="http://www.w3.org/TR/2005/REC-xop10-20050125/#identifying_xop_documents">Identifying XOP Documents</a> are met.
     * This value must not change during the unmarshalling process.</p>
     *
     * @return true when MIME context is a XOP Document.
     */
    public boolean isXOPPackage() { return false; }
}

/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.olingo.odata4.producer.core.testutil;

import java.util.Arrays;
import java.util.List;

import org.apache.olingo.odata4.commons.api.edm.helper.FullQualifiedName;
import org.apache.olingo.odata4.commons.api.edm.provider.ComplexType;
import org.apache.olingo.odata4.commons.api.edm.provider.EntitySet;
import org.apache.olingo.odata4.commons.api.edm.provider.EntityType;
import org.apache.olingo.odata4.commons.api.edm.provider.Property;
import org.apache.olingo.odata4.commons.api.edm.provider.PropertyRef;
import org.apache.olingo.odata4.commons.api.exception.ODataException;

//Adds a abc entity set with properties a,b,c,d,e,f to the technical reference scenario
public class EdmTechTestProvider extends EdmTechProvider {

  public static final FullQualifiedName nameCTabc = new FullQualifiedName(nameSpace, "CTabc");

  Property propertyAInt16 = new Property().setName("a").setType(nameInt16);
  Property propertyBInt16 = new Property().setName("b").setType(nameInt16);
  Property propertyCInt16 = new Property().setName("c").setType(nameInt16);
  Property propertyDInt16 = new Property().setName("d").setType(nameInt16);
  Property propertyEInt16 = new Property().setName("e").setType(nameInt16);
  Property propertyFInt16 = new Property().setName("f").setType(nameInt16);
  public static final FullQualifiedName nameETabc = new FullQualifiedName(nameSpace, "ETabc");

  @Override
  public ComplexType getComplexType(final FullQualifiedName complexTypeName) throws ODataException {
    if (complexTypeName.equals(nameCTabc)) {
      return new ComplexType()
          .setName("CTabc")
          .setProperties(Arrays.asList(
              propertyAInt16, propertyBInt16, propertyCInt16,
              propertyDInt16, propertyEInt16, propertyFInt16
              ));

    }

    return super.getComplexType(complexTypeName);
  }

  @Override
  public EntitySet getEntitySet(final FullQualifiedName entityContainer, final String name) throws ODataException {
    if (entityContainer == nameContainer) {
      if (name.equals("ESabc")) {
        return new EntitySet()
            .setName("ESabc")
            .setType(nameETabc);
      }
    }

    return super.getEntitySet(entityContainer, name);
  }

  @Override
  public EntityType getEntityType(final FullQualifiedName entityTypeName) throws ODataException {
    List<PropertyRef> oneKeyPropertyInt16 = Arrays.asList(new PropertyRef().setPropertyName("a"));

    if (entityTypeName.equals(nameETabc)) {
      return new EntityType()
          .setName("ETabc")
          .setProperties(Arrays.asList(
              propertyAInt16, propertyBInt16, propertyCInt16,
              propertyDInt16, propertyEInt16, propertyFInt16))
          .setKey(oneKeyPropertyInt16);
    }

    return super.getEntityType(entityTypeName);
  }

}
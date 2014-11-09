package fr.gouv.vitam.schema;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import fr.gouv.vitam.schema.AppraisalRule.AppraisalAction;
import fr.gouv.vitam.schema.ArchiveTransfer.DescriptiveMetadataPackage;
import fr.gouv.vitam.schema.ArchiveTransfer.TechnicalMetadataPackage;
import fr.gouv.vitam.schema.BinaryTechnicalMetadataObject.FileInfo;
import fr.gouv.vitam.schema.BinaryTechnicalMetadataObject.Identification;
import fr.gouv.vitam.schema.LevelDescriptiveMetadata.LevelManagementMetadataContent;
import fr.gouv.vitam.schema.PhysicalTechnicalMetadataObject.Measurement;
import fr.gouv.vitam.schema.PhysicalTechnicalMetadataObject.UNIT;
import fr.gouv.vitam.schema.BooleanQuery.Operator;
import fr.gouv.vitam.schema.BooleanQuery.DoubleOperator;
import fr.gouv.vitam.schema.BooleanQuery.Query;
import fr.gouv.vitam.schema.BooleanQuery.SimpleOperator;
import fr.gouv.vitam.schema.StorageRule.STORAGEACTION;
import fr.gouv.vitam.schema.TechnicalMetadata.Tool;
import fr.gouv.vitam.utils.exception.InvalidParseOperationException;

@SuppressWarnings("javadoc")
public class ArchiveTransferTest {

    @Test
    public void testArchiveTransfer() {
        // Binary files
        BinaryDataObject binaryDataObject1 = new BinaryDataObject(new FileId("id1"), "uri1", "digest1", "algorithm1", 1);
        BinaryDataObject binaryDataObject2 = new BinaryDataObject(new FileId("id2"), "uri2", "digest2", "algorithm2", 2);
        BinaryDataObject binaryDataObject3 = new BinaryDataObject(new FileId("id3"), "uri3", "digest3", "algorithm3", 3);
        // Physical Object
        PhysicalDataObject physicalDataObject1 = new PhysicalDataObject(new FileId(), "physicalId1");
        PhysicalDataObject physicalDataObject2 = new PhysicalDataObject(new FileId(), "physicalId2");

        // Build TechnicalMetadata
        TechnicalMetadata technicalMetadata = new TechnicalMetadata();
        
        // CodeList for TechnicalMetadata
        technicalMetadata.setDataObjectVersionCodeList(new CodeList("listId9"))
            .setFileFormatCodeList(new CodeList("listId10")).setMimeTypeCodeList(new CodeList("listId11"));
        
        // Tools used in Technical identification
        technicalMetadata.addTool(new Tool("name1", "version1"));
        Tool tool = new Tool("name2", "version2")
            .addParameterVersion("param1").addParameterVersion("param2");
        technicalMetadata.addTool(tool);

        // Binary Technical Identification
        FileInfo fileInfo = new FileInfo(100, "filename1", new DateTime(1999, 1, 30, 22, 55));
        Identification identification = new Identification("formatLitteral1", "mimeType1", "formatId1");
        BinaryTechnicalMetadataObject binaryTechnicalMetadataObject = new BinaryTechnicalMetadataObject(binaryDataObject1.getId(), identification, fileInfo)
            .setCoreTechnicalMetadata(new DefaultCoreTechnicalMetadata())
            .setDescriptiveTechnicalMetadata(new DescriptiveTechnicalMetadataContent())
            .setTechnicalIdentificationDate(new DateTime());
        technicalMetadata.addTechnicalMetadataObject(binaryTechnicalMetadataObject);

        // Binary Technical Identification using a group
        fileInfo = new FileInfo(110, "filename2", new DateTime(2014, 12, 31, 23, 59))
            .setCreatingApplicationName("creatingApplicationName1")
            .setCreatingApplicationVersion("creatingApplicationVersion1")
            .setCreatingOs("creatingOs1")
            .setLastModified(new DateTime());
        identification = new Identification("formatId2");
        String groupId = "groupId1";
        binaryTechnicalMetadataObject = new BinaryTechnicalMetadataObject(binaryDataObject2.getId(), groupId, "version3", identification, fileInfo)
            .setCoreTechnicalMetadata(new DefaultCoreTechnicalMetadata())
            .setDescriptiveTechnicalMetadata(new DescriptiveTechnicalMetadataContent())
            .setTechnicalIdentificationDate(new DateTime());
        technicalMetadata.addTechnicalMetadataObject(binaryTechnicalMetadataObject);
        // Physical Technical Identification using a group
        technicalMetadata.addTechnicalMetadataObject(new PhysicalTechnicalMetadataObject(physicalDataObject2.getId(), groupId, "version2"));

        // Physical Technical Identification
        PhysicalTechnicalMetadataObject physicalTechnicalMetadataObject = new PhysicalTechnicalMetadataObject(physicalDataObject1.getId())
            .setDepth(new Measurement(12, UNIT.centimetre))
            .setDiameter(new Measurement(13, UNIT.inch))
            .setHeight(new Measurement(14, UNIT.CMT))
            .setLength(new Measurement(15, UNIT.micrometre))
            .setThickness(new Measurement(16.6, UNIT.FOOT))
            .setWidth(new Measurement(17.7, UNIT.micrometre))
            .setShape("shape1")
            .setWeight(new Measurement(18.8, UNIT.kilogram));
        technicalMetadata.addTechnicalMetadataObject(physicalTechnicalMetadataObject);

        // ArchiveTransfer main data
        Organization archivalAgency = new Organization("idArchivalAgency", "description1");
        Organization transferringAgency = new Organization("idTransferringAgency", "description2");
        ArchiveTransfer archiveTransfer = new ArchiveTransfer("messageIdentifier1", "archivalAgreement1", archivalAgency, transferringAgency);
        archiveTransfer.setSignature(new DefaultInformation());
        
        // CodeList of ArchiveTransfer
        archiveTransfer.setReplyCodeList(new CodeList("listId2", "listName2", "listVersionId2", "listSchemeUri2"));
        archiveTransfer.setDigestAlgorithmCodeList(new CodeList("listId1", "listName1", "listVersionId1", "listSchemeUri1"));

        // Optional
        archiveTransfer.setTransferRequestReplyIdentifer("transferRequestReplyIdentifer");

        // Build TechnicalMetadataPackage
        archiveTransfer.setTechnicalMetadataPackage(new TechnicalMetadataPackage(technicalMetadata));

        // Add all Data Objects
        archiveTransfer.addBinaryDataObject(binaryDataObject1);
        archiveTransfer.addBinaryDataObject(binaryDataObject2);
        archiveTransfer.addBinaryDataObject(binaryDataObject3);
        archiveTransfer.addPhysicalDataObject(physicalDataObject1);
        archiveTransfer.addPhysicalDataObject(physicalDataObject2);
        
        // DescriptiveMatada Root
        DescriptiveMetadata descriptiveMetadata = new DescriptiveMetadata();
        // CodeList of DescriptiveMetadata
        descriptiveMetadata.setaAppraisalRuleCodeList(new CodeList("listId3", "listName1", "listVersionId1", "listSchemeUri1"));
        descriptiveMetadata.setAccessRestrictionRuleCodeList(new CodeList("listId4", "listName1", "listVersionId1", "listSchemeUri1"));
        descriptiveMetadata.setClassificationRuleCodeList(new CodeList("listId5", "listName1", "listVersionId1", "listSchemeUri1"));
        descriptiveMetadata.setDisseminationRestrictionRuleCodeList(new CodeList("listId6", "listName1", "listVersionId1", "listSchemeUri1"));
        descriptiveMetadata.setReuseRestrictionRuleCodeList(new CodeList("listId7", "listName1", "listVersionId1", "listSchemeUri1"));
        descriptiveMetadata.setStorageRuleCodeList(new CodeList("listId8", "listName1", "listVersionId1", "listSchemeUri1"));
        
        // From a file
        descriptiveMetadata.addLevelDescriptiveMetadata(new LevelDescriptiveMetadata(binaryDataObject3.getId()));
        // From an already (fictive) defined Level
        descriptiveMetadata.addLevelDescriptiveMetadata(new LevelDescriptiveMetadata("xmlRefId"));

        // Real one with a Tree structure
        // Set Management
        LevelManagementMetadataContent levelManagementMetadataContent = new LevelManagementMetadataContent();
        AccessRestrictionRule accessRestrictionRule = (AccessRestrictionRule) new AccessRestrictionRule(false, true)
            .addRefNonRuleId("refNonRuleId1").addRefNonRuleId("refNonRuleId2")
            .addRule(new RuleApplication("rule1", new DateTime())).addRule(new RuleApplication("rule2", null));
        AppraisalRule appraisalRule = (AppraisalRule) new AppraisalRule(true, AppraisalAction.Destroy, false)
            .addRule(new RuleApplication("rule3", new DateTime(0)));
        ClassificationRule classificationRule = new ClassificationRule(false, "classificationLevel1", "mention1", "classificationOwner1", 
                new DateTime(System.currentTimeMillis()+365*24*3600000), false);
        // Set LevelCreationControl
        BooleanQuery booleanQuery2 = new BooleanQuery(Operator.OR)
            .addQuery(new Query(DoubleOperator.GT, "key2", "keyRef2", null))
            .addQuery(new Query(DoubleOperator.SIZE, "key3", null, 42))
            .addQuery(new Query(DoubleOperator.TERM, "key4", null, "value3"));
        BooleanQuery booleanQuery = new BooleanQuery(Operator.AND)
            .addQuery(new Query(SimpleOperator.EXISTS, "key1")).addQuery(booleanQuery2);
        levelManagementMetadataContent.setLevelCreationControl(new LevelCreationControl(true, true, false, booleanQuery));
        levelManagementMetadataContent.setAccessRestrictionRule(accessRestrictionRule);
        levelManagementMetadataContent.setAppraisalRule(appraisalRule);
        levelManagementMetadataContent.setClassificationRule(classificationRule);
        levelManagementMetadataContent.setDisseminationRestrictionRule(new DisseminationRestrictionRule(true, true));
        levelManagementMetadataContent.setReuseRestrictionRule(new ReuseRestrictionRule(false));
        levelManagementMetadataContent.setStorageRule(new StorageRule(false, STORAGEACTION.Transfer, false));

        // Add Description
        LevelDescriptiveMetadataContent levelDescriptiveMetadataContent = new LevelDescriptiveMetadataContent();
        LevelDescriptiveMetadataContent restrictedLevelDescriptiveMetadataContent = new LevelDescriptiveMetadataContent();
        
        // Finalize Level for itself
        LevelDescriptiveMetadata levelDescriptiveMetadata = new LevelDescriptiveMetadata(new MessageIdentifier("messageId2", archiveTransfer.getMessageIdentifier()), "xmlId2", 
                levelManagementMetadataContent, levelDescriptiveMetadataContent, restrictedLevelDescriptiveMetadataContent);
        
        // build sub level
        // Default example of LevelManagement for sub level
        booleanQuery = new BooleanQuery(Operator.AND).addQuery(new Query(DoubleOperator.TERM, "key2", "keyref2", null));
        LevelCreationControl levelCreationControl = new LevelCreationControl(true, true, false, booleanQuery);
        levelManagementMetadataContent = new LevelManagementMetadataContent().setLevelCreationControl(levelCreationControl);
        
        // Sub node using Reference to existing Level in AES
        LevelDescriptiveMetadata levelDescriptiveMetadata2 = new LevelDescriptiveMetadata(new MessageIdentifier(null, null), "xmlId3", 
                levelManagementMetadataContent, 
                new LevelDescriptiveMetadataContent(), new LevelDescriptiveMetadataContent());
        levelDescriptiveMetadata2.addLevelDescriptiveMetadataReference(booleanQuery);
        levelDescriptiveMetadata.addLevelDescriptiveMetadata(levelDescriptiveMetadata2);
        
        // Sub node using DataObjectReferences from ArchiveTransfer
        levelDescriptiveMetadata2 = new LevelDescriptiveMetadata(null, "xmlId4", 
                levelManagementMetadataContent, 
                new LevelDescriptiveMetadataContent(), new LevelDescriptiveMetadataContent());
        levelDescriptiveMetadata2.addDataObjectReference(new DataObjectReference("xmlId5", binaryDataObject1.getId()))
            .addDataObjectReference(new DataObjectReference("xmlId6", groupId))
            .addDataObjectReference(new DataObjectReference("xmlId7", physicalDataObject1.getId()));
        levelDescriptiveMetadata.addLevelDescriptiveMetadata(levelDescriptiveMetadata2);

        // Sub node having no sub levels (NullObject)
        levelDescriptiveMetadata2 = new LevelDescriptiveMetadata(null, "xmlId5", 
                levelManagementMetadataContent, 
                new LevelDescriptiveMetadataContent(), new LevelDescriptiveMetadataContent());
        levelDescriptiveMetadata.addLevelDescriptiveMetadata(levelDescriptiveMetadata2);
        
        // Finalize DescriptiveMetadata package
        descriptiveMetadata.addLevelDescriptiveMetadata(levelDescriptiveMetadata);
        // Build DescriptiveMetadataPackage
        archiveTransfer.setDescriptiveMetadataPackage(new DescriptiveMetadataPackage(descriptiveMetadata));
                
        try {
            // Print Json format
            System.err.println(archiveTransfer.generateJsonString());
            // print Xml format
            System.out.println(archiveTransfer.generateXmlString());
        } catch (InvalidParseOperationException e) {
            e.printStackTrace();
            fail(e.getMessage());
        }
        assertNotNull("Json not empty", archiveTransfer.generateJson());
    }

}

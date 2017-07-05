-- SID
INSERT INTO acl_sid (id, principal, sid) VALUES (1, true, 'root');
INSERT INTO acl_sid (id, principal, sid) VALUES (2, true, 'GRP_APCN');

-- CLASS
INSERT INTO acl_class (id, class) VALUES (1, 'my.edu.umk.pams.intake.system.model.InModule');

-- object identity
INSERT INTO acl_object_identity (id, object_id_class, object_id_identity, parent_object, owner_sid, entries_inheriting) VALUES (1, 1, 2, null, 1, true);

-- entry
INSERT INTO acl_entry (id, acl_object_identity, ace_order, sid, mask, granting, audit_success, audit_failure) VALUES (1, 1, 0, 2, 1, true, false, false);
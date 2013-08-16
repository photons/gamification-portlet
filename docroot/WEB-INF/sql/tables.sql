create table GM_Badge (
	badgeId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	badgeName VARCHAR(75) null,
	badgeLevel INTEGER,
	data_ TEXT null
);
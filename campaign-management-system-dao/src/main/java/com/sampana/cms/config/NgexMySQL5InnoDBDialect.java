/**
 * 
 */
package com.sampana.cms.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Sets the default charset to UTF-8.
 * 
 *@author Sudhanshu
 *
 */
public class NgexMySQL5InnoDBDialect extends MySQL5InnoDBDialect {

	@Override
	public String getTableTypeString() {
		return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
	}

}

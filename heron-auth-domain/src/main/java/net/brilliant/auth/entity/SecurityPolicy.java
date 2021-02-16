/*
* Copyright 2017, Bui Quy Duc
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.brilliant.auth.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.ccs.GlobalSharedConstants;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * Module.
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aux_security_policy")
public class SecurityPolicy extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6670794612606704195L;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = GlobalSharedConstants.PROP_NAME)
	private String name;

	@Column(name = "info", columnDefinition="text")
	private String info;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private SecurityPolicy parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public SecurityPolicy getParent() {
		return parent;
	}

	public void setParent(SecurityPolicy parent) {
		this.parent = parent;
	}
	
}

package com.misternerd.resteasytox.swift.objects;

import java.util.ArrayList;

import com.misternerd.resteasytox.swift.helper.BuildableHelper;

public class SwiftProtocol extends Buildable
{
	private final String name;
	private final ArrayList<SwiftMethod> methods = new ArrayList<>();


	public SwiftProtocol(String name)
	{
		super();
		this.name = name;
	}


	public void addMethod(SwiftMethod method)
	{
		methods.add(method);
	}


	@Override
	public void build(StringBuilder sb)
	{
		int indent = 0;
		BuildableHelper.addSpace(sb);
		sb.append("protocol ").append(name).append(" {");

		indent++;
		if (!methods.isEmpty())
		{
			BuildableHelper.addNewline(sb);

			for (SwiftMethod method : methods)
			{
				method.buildNewline(sb, indent);
			}

		}
		
		indent--;
		BuildableHelper.addNewline(sb);
		sb.append("}");

	}

}
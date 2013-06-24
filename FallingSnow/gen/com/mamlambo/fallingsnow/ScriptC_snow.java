/*
 * Copyright (C) 2011-2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source Renderscript file: /home/android/workspace/FallingSnow/src/com/mamlambo/fallingsnow/snow.rs
 */
package com.mamlambo.fallingsnow;

import android.renderscript.*;
import android.content.res.Resources;

/**
 * @hide
 */
public class ScriptC_snow extends ScriptC {
    private static final String __rs_resource_name = "snow";
    // Constructor
    public  ScriptC_snow(RenderScript rs) {
        this(rs,
             rs.getApplicationContext().getResources(),
             rs.getApplicationContext().getResources().getIdentifier(
                 __rs_resource_name, "raw",
                 rs.getApplicationContext().getPackageName()));
    }

    public  ScriptC_snow(RenderScript rs, Resources resources, int id) {
        super(rs, resources, id);
    }

    private FieldPacker __rs_fp_F32_2;
    private FieldPacker __rs_fp_MESH;
    private FieldPacker __rs_fp_PROGRAM_FRAGMENT;
    private final static int mExportVarIdx_snowMesh = 0;
    private Mesh mExportVar_snowMesh;
    public synchronized void set_snowMesh(Mesh v) {
        setVar(mExportVarIdx_snowMesh, v);
        mExportVar_snowMesh = v;
    }

    public Mesh get_snowMesh() {
        return mExportVar_snowMesh;
    }

    private final static int mExportVarIdx_gPFSnow = 1;
    private ProgramFragment mExportVar_gPFSnow;
    public synchronized void set_gPFSnow(ProgramFragment v) {
        setVar(mExportVarIdx_gPFSnow, v);
        mExportVar_gPFSnow = v;
    }

    public ProgramFragment get_gPFSnow() {
        return mExportVar_gPFSnow;
    }

    private final static int mExportVarIdx_snow = 2;
    private ScriptField_Snow mExportVar_snow;
    public void bind_snow(ScriptField_Snow v) {
        mExportVar_snow = v;
        if (v == null) bindAllocation(null, mExportVarIdx_snow);
        else bindAllocation(v.getAllocation(), mExportVarIdx_snow);
    }

    public ScriptField_Snow get_snow() {
        return mExportVar_snow;
    }

    private final static int mExportVarIdx_vpConstants = 3;
    private ScriptField_VpConsts mExportVar_vpConstants;
    public void bind_vpConstants(ScriptField_VpConsts v) {
        mExportVar_vpConstants = v;
        if (v == null) bindAllocation(null, mExportVarIdx_vpConstants);
        else bindAllocation(v.getAllocation(), mExportVarIdx_vpConstants);
    }

    public ScriptField_VpConsts get_vpConstants() {
        return mExportVar_vpConstants;
    }

    private final static int mExportVarIdx_wind = 4;
    private Float2 mExportVar_wind;
    public synchronized void set_wind(Float2 v) {
        mExportVar_wind = v;
        FieldPacker fp = new FieldPacker(8);
        fp.addF32(v);
        setVar(mExportVarIdx_wind, fp);
    }

    public Float2 get_wind() {
        return mExportVar_wind;
    }

    private final static int mExportVarIdx_grav = 5;
    private Float2 mExportVar_grav;
    public synchronized void set_grav(Float2 v) {
        mExportVar_grav = v;
        FieldPacker fp = new FieldPacker(8);
        fp.addF32(v);
        setVar(mExportVarIdx_grav, fp);
    }

    public Float2 get_grav() {
        return mExportVar_grav;
    }

    private final static int mExportFuncIdx_initSnow = 0;
    public void invoke_initSnow() {
        invoke(mExportFuncIdx_initSnow);
    }

}


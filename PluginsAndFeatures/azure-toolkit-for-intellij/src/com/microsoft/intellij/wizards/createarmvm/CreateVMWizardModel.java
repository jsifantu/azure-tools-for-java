/**
 * Copyright (c) Microsoft Corporation
 * <p/>
 * All rights reserved.
 * <p/>
 * MIT License
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 * the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED *AS IS*, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.microsoft.intellij.wizards.createarmvm;

import com.intellij.openapi.project.Project;
import com.microsoft.azure.management.compute.AvailabilitySet;
import com.microsoft.azure.management.compute.VirtualMachineImage;
import com.microsoft.azure.management.network.Network;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.azure.management.network.PublicIpAddress;
import com.microsoft.azure.management.resources.fluentcore.arm.Region;
import com.microsoft.intellij.wizards.VMWizardModel;
import com.microsoft.intellij.wizards.createvm.MachineSettingsStep;
import com.microsoft.intellij.wizards.createvm.SubscriptionStep;
import com.microsoft.tooling.msservices.model.storage.ArmStorageAccount;
import com.microsoft.tooling.msservices.serviceexplorer.azure.vmarm.VMArmServiceModule;

public class CreateVMWizardModel extends VMWizardModel {
    private Region region;
    private VirtualMachineImage virtualMachineImage;
    private Network virtualNetwork;
    private ArmStorageAccount storageAccount;
//    private String availabilitySet;
    private PublicIpAddress publicIpAddress;
    private boolean withNewPip;
    private NetworkSecurityGroup networkSecurityGroup;
    private AvailabilitySet availabilitySet;
    private boolean withNewAvailabilitySet;

    public CreateVMWizardModel(VMArmServiceModule node) {
        super();

        Project project = (Project) node.getProject();

        add(new SubscriptionStep(this, project));
        add(new SelectImageStep(this, project));
        add(new MachineSettingsStep(this, project));
        add(new SettingsStep(this, project, node));
    }

    public String[] getStepTitleList() {
        return new String[]{
                "Subscription",
                "Select Image",
                "Machine Settings",
                "Associated Resources"
        };
    }

    public VirtualMachineImage getVirtualMachineImage() {
        return virtualMachineImage;
    }

    public void setVirtualMachineImage(VirtualMachineImage virtualMachineImage) {
        this.virtualMachineImage = virtualMachineImage;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

//    public VirtualMachineSize getSize() {
//        return size;
//    }

//    public void setSize(VirtualMachineSize size) {
//        this.size = size;
//    }

    public Network getVirtualNetwork() {
        return virtualNetwork;
    }

    public void setVirtualNetwork(Network virtualNetwork) {
        this.virtualNetwork = virtualNetwork;
    }

    public ArmStorageAccount getStorageAccount() {
        return storageAccount;
    }

    public void setStorageAccount(ArmStorageAccount storageAccount) {
        this.storageAccount = storageAccount;
    }

    public PublicIpAddress getPublicIpAddress() {
        return publicIpAddress;
    }

    public void setPublicIpAddress(PublicIpAddress publicIpAddress) {
        this.publicIpAddress = publicIpAddress;
    }

    public boolean isWithNewPip() {
        return withNewPip;
    }

    public void setWithNewPip(boolean withNewPip) {
        this.withNewPip = withNewPip;
    }

    public NetworkSecurityGroup getNetworkSecurityGroup() {
        return networkSecurityGroup;
    }

    public void setNetworkSecurityGroup(NetworkSecurityGroup networkSecurityGroup) {
        this.networkSecurityGroup = networkSecurityGroup;
    }

    public AvailabilitySet getAvailabilitySet() {
        return availabilitySet;
    }

    public void setAvailabilitySet(AvailabilitySet availabilitySet) {
        this.availabilitySet = availabilitySet;
    }

    public boolean isWithNewAvailabilitySet() {
        return withNewAvailabilitySet;
    }

    public void setWithNewAvailabilitySet(boolean withNewAvailabilitySet) {
        this.withNewAvailabilitySet = withNewAvailabilitySet;
    }

    //    public String getAvailabilitySet() {
//        return availabilitySet;
//    }
//
//    public void setAvailabilitySet(String availabilitySet) {
//        this.availabilitySet = availabilitySet;
//    }
}

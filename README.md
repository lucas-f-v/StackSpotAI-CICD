# StackSpotAI-CICD

## Purpose
This repository serves as a way to test and deploy remote quick commands. The remote-qc workflow will send every committed change to this repository to StackSpot AI.

## Details
This repository and quick command are under the @sa-azure account, and only works with quick commands from the sa-azure account.

## Changing StackSpot Accounts
If you would like to switch the Stackspot account associated with this repository, you have to replace the secrets in this repository with the details found in `EDP > Account > Access-Token` (generating a new client key will deprecate the previous one).

## Changing Quick Commands
To change the Quick Command, you need to change the QC's slug on line 33 of the `remote-qc.yaml` file. The quick command you are trying to execute should be available to you in the account configured in this repository. If you are trying to alter the QC to one in a different account, you will have to also change the StackSpot account associated with this repository. To do so, follow the steps in "Changing StackSpot Accounts".

### Also, this is my dog:
<img src="https://github.com/user-attachments/assets/f985638b-df62-4237-9b57-a1ba1122401e" alt="nice-dog(2)" width="300"/>

![nice-dog(4)](https://github.com/user-attachments/assets/71c1a018-5079-4e75-8ed7-9546ee3a7bd6)

BANANA
user=user
pass=password
h
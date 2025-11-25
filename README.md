Pessimistic lock thread 2 waits till thread 1 release the lock. But in opimal locking it uses version field if read version is different from write version then throws error.

**When use Pessimistic_Write Lock only one transaction can hold the lock for the read/write hence all concurrent transaction are executed sequetially:**

<img width="864" height="158" alt="image" src="https://github.com/user-attachments/assets/97f7fb94-ddb2-4817-a960-ebeec4902bf4" />

**When use  Pessimistic_Read lock multiple read transaction is possible but only single write has the lock. hence when two transaction read the data it is granted but while update it throws error:**

<img width="1061" height="271" alt="image" src="https://github.com/user-attachments/assets/5314dce8-43e8-439f-bd00-419744137da2" />


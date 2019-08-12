# Design Stack Overflow

Stack Overflow is one of the largest online communities for developers to learn and share their knowledge. The website provides a platform for its users to ask and answer questions, and through membership and active participation, to vote questions and answers up or down. Users can edit questions and answers in a fashion similar to a [wiki](https://en.wikipedia.org/wiki/Wiki).

Users of Stack Overflow can earn reputation points and badges. For example, a person is awarded ten reputation points for receiving an “up” vote on an answer and five points for the “up” vote of a question. The can also receive badges for their valued contributions. A higher reputation lets users unlock new privileges like the ability to vote, comment on, and even edit other people’s posts.

<p align="center">
  <img src="images/stackoverflow.png"><br>
</p>

## Requirements and Goals of the System

We will be designing a system with the following requirements:
1. Any non-member (guest) can search and view questions. However, to add or upvote a question, they have to become a member.<br>
2. Members should be able to post new questions.<br>
3. Members should be able to add an answer to an open question.<br>
4. Members can add comments to any question or answer.<br>
5. A member can upvote a question, answer or comment.<br>
6. Members can flag a question, answer or comment, for serious problems or moderator attention.<br>
7. Any member can add a [bounty](https://stackoverflow.com/help/bounty) to their question to draw attention.<br>
8. Members will earn [badges](https://stackoverflow.com/help/badges) for being helpful.<br>
9. Members can vote to [close](https://stackoverflow.com/help/closed-questions) question; Moderators can close or reopen any question.<br>
10. Members can add [tags](https://stackoverflow.com/help/tagging) to their questions. A tag is a word or phrase that describes the topic of the question.<br>
11. Members can vote to [delete](https://stackoverflow.com/help/deleted-questions) extremely off-topic or very low-quality questions.<br>
12. Moderators can close a question or undelete an already deleted question.<br>
13. The system should also be able to identify most frequently used tags in the questions.<br>

## Use-case Diagram

We have five main actors in our system:

* **Admin**: Mainly responsible for blocking or unblocking members.<br>
* **Guest**: All guests can search and view questions.<br>
* **Member**: Members can perform all activities that guests can, in addition to which they can add/remove questions, answers, and comments. Members can delete and un-delete their questions, answers or comments.<br>
* **Moderator**: In addition to all the activities that members can perform, moderators can close/delete/undelete any question.<br>
* **System**: Mainly responsible for sending notifications and assigning badges to members.<br>

Here are the top use cases for Stack Overflow:
1. Search questions.<br>
2. Create a new question with bounty and tags.<br>
3. Add/modify answers to questions.<br>
4. Add comments to questions or answers.<br>
5. Moderators can close, delete, and un-delete any question.<br>

<p align="center">
  <img src="images/stackoverflow_usercase.svg"><br>
  <i>Use case diagram</i>
</p>

## Class diagram
Here are the main classes of Stack Overflow System:

* **Question**: This class is the central part of our system. It has attributes like Title and Description to define the question. In addition to this, we will track the number of times a question has been viewed or voted on. We should also track the status of a question, as well as closing remarks if the question is closed.<br>

* **Answer**: The most important attributes of any answer will be the text and the view count. In addition to that, we will also track the number of times an answer is voted on or flagged. We should also track if the question owner has accepted an answer.<br>

* **Comment**: Similar to answer, comments will have text, and view, vote, and flag counts. Members can add comments to questions and answers.<br>

* **Tag**: Tags will be identified by their names and will have a field for a description to define them. We will also track daily and weekly frequencies at which tags are associated with questions.<br>

* **Badge**: Similar to tags, badges will have a name and description.<br>

* **Photo**: Questions or answers can have photos.<br>

* **Bounty**: Each member, while asking a question, can place a bounty to draw attention. Bounties will have a total reputation and an expiry date.<br>

* **Account**: We will have four types of accounts in the system, guest, member, admin, and moderator. Guests can search and view questions. Members can ask questions and earn reputation by answering questions and from bounties.<br>

* **Notification**: This class will be responsible for sending notifications to members and assigning badges to members based on their reputations.<br>

<p align="center">
  <img src="images/stackoverflow_diagram.svg"><br>
  <i>Class diagram</i>
</p>

<p align="center">
  <img src="images/UML.svg"><br>
</p>

## Activity diagrams

**Post a new question**: Any member or moderator can perform this activity. Here are the steps to post a question:

<p align="center">
  <img src="images/stackoverflow_activity.svg"><br>
</p>

## Sequence Diagram

Following is the sequence diagram for creating a new question:

<p align="center">
  <img src="images/stackoverflow_sequence.svg"><br>
</p>



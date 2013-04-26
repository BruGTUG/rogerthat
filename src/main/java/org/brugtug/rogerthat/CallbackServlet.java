package org.brugtug.rogerthat;

import com.mobicage.rogerthat.CallBackApi;
import com.mobicage.rogerthat.CallBackApiServlet;
import com.mobicage.rogerthat.CallbackResult;
import com.mobicage.rogerthat.FriendInviteResult;
import com.mobicage.rogerthat.MessageStatus;
import com.mobicage.rogerthat.flow.FlowStep;
import com.mobicage.rogerthat.form.FormResult;

public class CallbackServlet extends CallBackApiServlet
{

   public CallbackServlet()
   {
      this.setSikKey("");
      this.setCallbackReceiver(createDynamicCallBackApi(null));
   }

   @Override
   protected CallBackApi createDynamicCallBackApi(String sikKey)
   {
      return new CallBackApi()
      {

         public CallbackResult messageUpdate(java.lang.String jsonRPCId, java.lang.String messageKey,
            java.lang.String member, java.util.Set<MessageStatus> status, java.lang.String answerId,
            long receivedTimestamp, long acknowledgeTimestamp, java.lang.String tag, java.lang.String resultKey,
            java.lang.String serviceIdentity)
         {
            // I received a message status update or a one-click response
            if (answerId == null)
            {
               log("User " + member + " has received message with tag " + tag);
            }
            else
            {
               log("User " + member + " has clicked a one-click response with id " + answerId);
            }
            return null;
         }

         @Override
         public CallbackResult formUpdate(java.lang.String jsonRPCId, java.lang.String messageKey,
            java.lang.String member, java.util.Set<MessageStatus> status, java.lang.String answerId,
            long receivedTimestamp, long acknowledgeTimestamp, java.lang.String tag, FormResult resultValue,
            java.lang.String resultKey, java.lang.String serviceIdentity)
         {
            return null;
         }

         @Override
         public void flowMemberResult(java.lang.String jsonRPCId, java.lang.String messageFlowRunId,
            java.lang.String member, java.lang.String endId, java.lang.String endMessageFlowId,
            java.lang.String parentMessageKey, java.util.List<FlowStep> steps, java.lang.String serviceIdentity)
         {
            // TODO Auto-generated method stub

         }

         @Override
         public void friendInviteResult(String arg0, String arg1, FriendInviteResult arg2, String arg3, String arg4)
         {
            // TODO Auto-generated method stub

         }

         @Override
         public FriendInviteResult friendInvited(java.lang.String jsonRPCId, java.lang.String email,
            java.lang.String name, java.lang.String message, java.lang.String tag, java.lang.String serviceIdentity)
         {
            // TODO Auto-generated method stub
            return null;
         }

         @Override
         public void friendRemoved(java.lang.String jsonRPCId, java.lang.String email, java.lang.String serviceIdentity)
         {
            // TODO Auto-generated method stub

         }

         @Override
         public CallbackResult messagingPoke(java.lang.String jsonRPCId, java.lang.String email, java.lang.String tag,
            java.lang.String context, java.lang.String resultKey, java.lang.String serviceIdentity)
         {
            // TODO Auto-generated method stub
            return null;
         }
      };
   }
}
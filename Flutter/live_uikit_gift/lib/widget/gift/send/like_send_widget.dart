import 'package:flutter/material.dart';

import '../../../common/index.dart';
import '../../../state/index.dart';
import 'like_send_controller.dart';

class LikeSendWidget extends StatelessWidget {
  final LikeSendController controller;

  LikeSendWidget({super.key, required this.controller}) {
    GiftStore().giftManager.getGiftData();
  }

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
      onPressed: () async {
        controller.sendLikeMessage();
      },
      style: ButtonStyle(
        padding: WidgetStateProperty.all(
          const EdgeInsets.all(0),
        ),
        backgroundColor:
            WidgetStateProperty.all<Color>(GiftColors.giftLightGrey),
        shape: WidgetStateProperty.all(
          RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(18),
          ),
        ),
      ),
      child: Image.asset(
        GiftImages.giftLikeSendIcon,
        package: Constants.pluginName,
        fit: BoxFit.fill,
      ),
    );
  }
}

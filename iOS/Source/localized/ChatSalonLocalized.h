//
//  ChatSalonLocalized.h
//  Pods
//
//  Created by abyyxwang on 2021/5/6.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN


#pragma mark - Base
extern NSBundle *ChatSalonBundle(void);
extern NSString *TCSLocalizeFromTable(NSString *key, NSString *table);
extern NSString *TCSLocalizeFromTableAndCommon(NSString *key, NSString *common, NSString *table);

#pragma mark - Replace String
extern NSString *LocalizeReplaceXX(NSString *origin, NSString *xxx_replace);
extern NSString *LocalizeReplace(NSString *origin, NSString *xxx_replace, NSString *yyy_replace);
extern NSString *LocalizeReplaceThreeCharacter(NSString *origin, NSString *xxx_replace, NSString *yyy_replace, NSString *zzz_replace);
extern NSString *LocalizeReplaceFourCharacter(NSString *origin, NSString *xxx_replace, NSString *yyy_replace, NSString *zzz_replace, NSString *mmm_replace);
extern NSString *LocalizeReplaceFiveCharacter(NSString *origin, NSString *xxx_replace, NSString *yyy_replace, NSString *zzz_replace, NSString *mmm_replace, NSString *nnn_replace);

#pragma mark - TRTC
extern NSString *const ChatSalon_Localize_TableName;
extern NSString *ChatSalonLocalize(NSString *key);

NS_ASSUME_NONNULL_END

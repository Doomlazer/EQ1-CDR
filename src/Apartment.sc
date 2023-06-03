;;; Sierra Script 1.0 - (do not remove this comment)
(script# 815)
(include sci.sh)
(use Main)
(use n819)
(use EcoFeature)
(use RTRandCycle)
(use PolyPath)
(use CueObj)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(class Apartment of EcoFeature
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		modNum -1
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		sightAngle 26505
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 0
		lookStr 0
		BelongsTo 0
		IamHome 0
		bitValue 0
		light 0
		lightX 0
		lightY 0
		lightMsg 0
		swimX 0
		swimY 0
		egoPri 0
		newRoom 0
	)
	
	(method (init param1)
		(self approachVerbs: 4 1 2)
		(if param1
			(= light (Clone param1))
			(light
				x: lightX
				y: lightY
				loop: (- (light loop?) IamHome)
				setCycle: Fwd
				init:
			)
			(if (not IamHome) (light setCycle: 0 stopUpd:))
		)
		(super init: &rest)
		(gEcoKeyDownHandler addToFront: self)
		(gEcoMouseDownHandler addToFront: self)
	)
	
	(method (dispose)
		(if light (light dispose:))
		(gEcoKeyDownHandler delete: self)
		(gEcoMouseDownHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(User canInput:)
				(!= (pEvent type?) evVERB)
				(not (pEvent modifiers?))
				(or
					(== (pEvent message?) KEY_RETURN)
					(& (pEvent type?) evMOUSEBUTTON)
				)
				(== (gIconBar curIcon?) (gIconBar at: 0))
				(self onMe: pEvent)
			)
			(CueObj state: 0 cycles: 0 client: self theVerb: 4)
			(gEgo
				setMotion: PolyPath approachX (+ (gEgo z?) approachY) CueObj
			)
			(pEvent claimed: 1)
		else
			(super handleEvent: pEvent)
		)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (not (proc999_5 theVerb 1 4 6 2 3 7 8))
			(= temp0 theVerb)
			(= theVerb 44)
		)
		(switch theVerb
			(1
				(if IamHome
					(EcoNarrator init: 4 0 0 9)
				else
					(EcoNarrator init: 4 0 0 10)
				)
			)
			(4
				(cond 
					((gEgo has: 25) (EcoNarrator init: 4 0 0 88))
					(
						(and
							(gCast contains: (ScriptID 200 7))
							(!= ((Inv at: 1) owner?) 200)
						)
						(EcoNarrator init: 4 0 0 95)
					)
					((== ((Inv at: 1) owner?) 200)
						(gEgo setPri: egoPri)
						(= gBelongsTo BelongsTo)
						(global2 setScript: (ScriptID 200 1) 0 self)
					)
					(else (global2 setScript: (ScriptID 202 0)))
				)
			)
			(2
				(cond 
					((gEgo has: 25) (EcoNarrator init: 4 0 0 88))
					((== ((Inv at: 1) owner?) 200) (EcoNarrator init: 4 0 0 89))
					((not (global2 script?)) (global2 setScript: (ScriptID 200 8)))
					(else (EcoNarrator init: 4 0 0 97))
				)
			)
			(44
				(cond 
					((proc819_5 7) (EcoNarrator init: 4 0 0 88))
					((== ((Inv at: 1) owner?) 200)
						(if (gCast contains: (ScriptID 200 7))
							(EcoNarrator init: 4 0 0 95)
						else
							(EcoNarrator init: 4 0 0 94)
						)
					)
					(else (EcoNarrator init: 4 0 0 93))
				)
			)
			(else 
				(super doVerb: theVerb temp0 &rest)
			)
		)
	)
)
